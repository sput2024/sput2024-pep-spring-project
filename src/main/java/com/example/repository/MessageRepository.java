package com.example.repository;


import com.example.entity.Message;

import org.springframework.data.jpa.repository.JpaRepository;


    public interface MessageRepository extends JpaRepository<Message, Integer> {
    }
    