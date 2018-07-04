package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Note;
import com.stylefeng.guns.modular.system.service.INoteService;

/**
 * 便签管理控制器
 *
 * @author fengshuonan
 * @Date 2018-07-04 13:32:31
 */
@Controller
@RequestMapping("/note")
public class NoteController extends BaseController {

    private String PREFIX = "/system/note/";

    @Autowired
    private INoteService noteService;

    /**
     * 跳转到便签管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "note.html";
    }

    /**
     * 跳转到添加便签管理
     */
    @RequestMapping("/note_add")
    public String noteAdd() {
        return PREFIX + "note_add.html";
    }

    /**
     * 跳转到修改便签管理
     */
    @RequestMapping("/note_update/{noteId}")
    public String noteUpdate(@PathVariable Integer noteId, Model model) {
        Note note = noteService.selectById(noteId);
        model.addAttribute("item",note);
        LogObjectHolder.me().set(note);
        return PREFIX + "note_edit.html";
    }

    /**
     * 获取便签管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return noteService.selectList(null);
    }

    /**
     * 新增便签管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Note note) {
        noteService.insert(note);
        return SUCCESS_TIP;
    }

    /**
     * 删除便签管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer noteId) {
        noteService.deleteById(noteId);
        return SUCCESS_TIP;
    }

    /**
     * 修改便签管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Note note) {
        noteService.updateById(note);
        return SUCCESS_TIP;
    }

    /**
     * 便签管理详情
     */
    @RequestMapping(value = "/detail/{noteId}")
    @ResponseBody
    public Object detail(@PathVariable("noteId") Integer noteId) {
        return noteService.selectById(noteId);
    }
}
