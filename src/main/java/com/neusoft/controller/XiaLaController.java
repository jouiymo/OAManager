package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.domain.ResJson;
import com.neusoft.domain.User;
import com.neusoft.domain.xiala.Bltype;
import com.neusoft.domain.xiala.Degreeorm;
import com.neusoft.domain.xiala.Education;
import com.neusoft.domain.xiala.Emform;
import com.neusoft.domain.xiala.Marital;
import com.neusoft.domain.xiala.Nation;
import com.neusoft.domain.xiala.Political;
import com.neusoft.domain.xiala.PostType;
import com.neusoft.domain.xiala.Sources;
import com.neusoft.exception.MyException;
import com.neusoft.repository.xiala.BltypeRepository;
import com.neusoft.repository.xiala.DegreeormRepository;
import com.neusoft.repository.xiala.EducationRepository;
import com.neusoft.repository.xiala.EmformRepository;
import com.neusoft.repository.xiala.MaritalRepository;
import com.neusoft.repository.xiala.NationRepository;
import com.neusoft.repository.xiala.PoliticalRepository;
import com.neusoft.repository.xiala.PostTypeRepository;
import com.neusoft.repository.xiala.SourcesRepository;
import com.neusoft.util.ResJsonUtil;

@RestController
public class XiaLaController {
	@Autowired
	BltypeRepository bltypeRepository;
	@Autowired
	DegreeormRepository degreeormRepository;
	@Autowired
	EducationRepository educationRepository;
	@Autowired
	EmformRepository emformRepository;
	@Autowired
	MaritalRepository maritalRepository;
	@Autowired
	NationRepository nationRepository;
	@Autowired
	PoliticalRepository politicalRepository;
	@Autowired
	PostTypeRepository postTypeRepository;
	@Autowired
	SourcesRepository sourcesRepository;

	@GetMapping(value = "/findbl")
	public ResJson<Bltype> findBl() throws MyException {
		List<Bltype> list = bltypeRepository.findAll();
		return ResJsonUtil.success(list, "查询血型列表成功");
	}

	@GetMapping(value = "/findde")
	public ResJson<Degreeorm> findDe() throws MyException {
		List<Degreeorm> list = degreeormRepository.findAll();
		return ResJsonUtil.success(list, "查询最高学位列表成功");
	}

	@GetMapping(value = "/finded")
	public ResJson<Education> findEd() throws MyException {
		List<Education> list = educationRepository.findAll();
		return ResJsonUtil.success(list, "查询最高学历列表成功");
	}

	@GetMapping(value = "/findem")
	public ResJson<Emform> findEm() throws MyException {
		List<Emform> list = emformRepository.findAll();
		return ResJsonUtil.success(list, "查询用工形式列表成功");
	}

	@GetMapping(value = "/findma")
	public ResJson<Marital> findMa() throws MyException {
		List<Marital> list = maritalRepository.findAll();
		return ResJsonUtil.success(list, "查询婚况列表成功");
	}

	@GetMapping(value = "/findna")
	public ResJson<Education> findNa() throws MyException {
		List<Nation> list = nationRepository.findAll();
		return ResJsonUtil.success(list, "查询民族列表成功");
	}

	@GetMapping(value = "/findpoli")
	public ResJson<Political> findPoli() throws MyException {
		List<Political> list = politicalRepository.findAll();
		return ResJsonUtil.success(list, "查询政治面貌列表成功");
	}

	@GetMapping(value = "/findpo")
	public ResJson<PostType> findPo() throws MyException {
		List<PostType> list = postTypeRepository.findAll();
		return ResJsonUtil.success(list, "查询岗位列表成功");
	}

	@GetMapping(value = "/findso")
	public ResJson<Sources> findSo() throws MyException {
		List<Sources> list = sourcesRepository.findAll();
		return ResJsonUtil.success(list, "查询人员来源列表成功");
	}

}
