package com.finalproject.librolead.publishers.repository;

import com.finalproject.librolead.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
