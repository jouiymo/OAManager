package com.neusoft.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Dept;
import com.neusoft.domain.EmployeeInfo;
import com.neusoft.domain.Post;
import com.neusoft.exception.MyException;
import com.neusoft.repository.EmpInfoRepository;
import com.neusoft.repository.PostRepository;
import com.neusoft.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	EmpInfoRepository empInfoRepository;
	
	@Override
	@Transactional
	public Post add(Post post) throws MyException {
		try {
			return postRepository.save(post);
		} catch (Exception e) {
		throw new MyException(12, "添加新岗位失败");
		}
		
	}

	@Override
	@Transactional
	public Post alter(Post post) throws MyException {
		try {
			return postRepository.save(post);
		} catch (Exception e) {
		throw new MyException(32, "修改岗位失败");
		}
		
	}

	@Override
	@Transactional
	public Post del(Post post) throws MyException {
		post = postRepository.findOne(post.getId());
		List<EmployeeInfo> list= empInfoRepository.findByPostName(post.getName());
		if(list.size()>0){
			throw new MyException(52, "删除岗位失败");
		}
		post.setState(-1);
		try {
			return postRepository.save(post);
		} catch (Exception e) {
		throw new MyException(52, "删除岗位失败");
		}
	}
	//----------------------------------------------------------------------------
	//需要实现分页与按部分的Id来查询列表,需要考虑是否显示已经被删除的部分
	@Override
	public Post findPostByPostId(Integer id) {
		
		return postRepository.findOne(id);
	}

	@Override
	public List<Post> findPostByPostName(String postName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPostByPostType(Integer postType) {
		// TODO Auto-generated method stub
		return null;
	}
//-------------------------------------------------------------------------------
	@Override
	public Page<Post> findPostByPost(Post post, Pageable pageable) throws MyException {
		post.setState(1);
		/*ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
	    		  .withStringMatcher(StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
	    		  .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写
	                .withMatcher("address"(此处写相应对象的属性), GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
	                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
		Example<Post> ex = Example.of(post,matcher);*/
		try {
			return postRepository.findByAuto(post, pageable);
		} catch (Exception e) {
			throw new MyException(62, "查询岗位列表失败");
		}
		
		
	}

}
