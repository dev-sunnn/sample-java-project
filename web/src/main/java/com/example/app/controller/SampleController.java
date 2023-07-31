package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.dto.SampleRequest;
import com.example.app.dto.SampleUpdateRequest;
import com.example.app.entity.Sample;
import com.example.app.service.SampleService;

/**
 * サンプル情報 Controller
 */
@Controller
public class SampleController {

  /**
   * サンプル情報 Service
   */
  @Autowired
  private SampleService sampleService;

  /**
   * サンプル情報 一覧画面を表示
   * 
   * @param model Model
   * @return サンプル情報 一覧画面
   */
  @GetMapping(value = "/sample/list")
  public String displayList(Model model) {
    List<Sample> samplelist = sampleService.searchAll();
    model.addAttribute("samplelist", samplelist);
    return "sample/list";
  }

  /**
   * サンプル情報 詳細画面を表示
   * 
   * @param id    表示するサンプルID
   * @param model Model
   * @return サンプル情報 詳細画面
   */
  @GetMapping("/sample/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    Sample data = sampleService.searchById(id);
    model.addAttribute("sampledata", data);
    return "sample/view";
  }

  /**
   * サンプル情報 新規登録画面を表示
   * 
   * @param model Model
   * @return サンプル情報 新規登録画面
   */
  @GetMapping(value = "/sample/add")
  public String displayAdd(Model model) {
    model.addAttribute("sampleRequest", new SampleRequest());
    return "sample/add";
  }

  /**
   * サンプル情報 新規登録
   * 
   * @param sampleRequest リクエストデータ
   * @param model            Model
   * @return サンプル情報 一覧画面
   */
  @RequestMapping(value = "/sample/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute SampleRequest sampleRequest, BindingResult result, Model model) {

    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "sample/add";
    }
    // サンプル情報の登録
    sampleService.create(sampleRequest);
    return "redirect:/sample/list";
  }

  /**
   * サンプル情報 編集画面を表示
   * @param id 表示するサンプルID
   * @param model Model
   * @return サンプル情報 編集画面
   */
  @GetMapping("/sample/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
    Sample sample = sampleService.searchById(id);
    SampleUpdateRequest sampleUpdateRequest = new SampleUpdateRequest();
    sampleUpdateRequest.setId(sample.getId());
    sampleUpdateRequest.setName(sample.getName());
    sampleUpdateRequest.setPath(sample.getPath());
    model.addAttribute("sampleUpdateRequest", sampleUpdateRequest);
    return "sample/edit";
  }

  /**
   * サンプル情報 更新
   * @param sampleRequest リクエストデータ
   * @param model Model
   * @return サンプル情報 詳細画面
   */
  @RequestMapping(value = "/sample/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute SampleUpdateRequest sampleUpdateRequest, BindingResult result, Model model) {

    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();

      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "sample/edit";
    }

    // サンプル情報の更新
    sampleService.update(sampleUpdateRequest);
    return String.format("redirect:/sample/%d", sampleUpdateRequest.getId());
  }

  /**
   * サンプル情報 物理：削除
   * @param id 表示するサンプル情報ID
   * @param model Model
   * @return サンプル情報 詳細画面
   */
  @GetMapping("/sample/{id}/delete")
  public String delete(@PathVariable Long id, Model model) {
    // サンプル情報の削除
    sampleService.delete(id);
    return "redirect:/sample/list";
  }
}
