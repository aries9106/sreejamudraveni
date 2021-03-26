package com.companyname.mynewproject.persistence;

import com.companyname.mynewproject.domain.Palindrome;
import org.springframework.data.repository.CrudRepository;

public interface PalindromeDao extends CrudRepository<Palindrome, Integer> {
}
