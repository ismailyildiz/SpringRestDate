package com.service;

import com.model.Result;

public interface IDateConverterService {

	Result convertUtcToBerlinZone(String time);

}
