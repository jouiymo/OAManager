package com.neusoft.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.neusoft.domain.Post;
import com.neusoft.exception.MyException;

/**
 * 岗位service
 * 
 * @author sky
 *
 */
public interface PostService {
	// 新增岗位
	public Post add(Post post) throws MyException;

	// 修改岗位
	public Post alter(Post post) throws MyException;

	// 删除岗位
	public Post del(Post post) throws MyException;

	// 通过岗位编号查询岗位列表
	public List<Post> findPostByPostId(Integer id) throws MyException;

	// 通过岗位名称查询岗位列表
	public List<Post> findPostByPostName(String postName) throws MyException;

	// 通过岗位类型查询岗位列表
	public List<Post> findPostByPostType(Integer postType) throws MyException;

	// 通过构建不完整岗位对象查询岗位列表
	public Page<Post> findPostByPost(Post post, Pageable pageable) throws MyException;

}
