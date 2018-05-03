package com.cinema.service;

import java.util.List;

import com.cinema.model.Authority;

public interface AuthorityService {
  List<Authority> findById(Long id);

  List<Authority> findByname(String name);
}
