package com.newbiest.calendar.repository;

import com.newbiest.base.repository.custom.IRepository;
import com.newbiest.calendar.model.ChangeShift;
import org.springframework.stereotype.Repository;


@Repository
public interface ChangeShiftRepository extends IRepository<ChangeShift, Long> {
}