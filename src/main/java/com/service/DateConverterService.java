package com.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.model.Result;

@Service
public class DateConverterService implements IDateConverterService {

	@Override
	public Result convertUtcToBerlinZone(String time) {

		Result result = new Result();

		String output = Instant.parse(time).atZone(ZoneId.of("Europe/Berlin"))
				.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN));

		result.setDisplayDate(output);
		return result;
	}

}
