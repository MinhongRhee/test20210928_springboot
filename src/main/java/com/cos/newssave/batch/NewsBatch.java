package com.cos.newssave.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.newssave.domain.News;
import com.cos.newssave.domain.NewsRepository;
import com.cos.newssave.util.NewsCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsBatch {
	
	private final NewsRepository newsRepository;
	private final NewsCraw naverCraw;
	
	@Scheduled(fixedDelay = 1000*60*1)
	public void testCount() {
		
		List<News> newsList = naverCraw.collect5();
		
		newsRepository.saveAll(newsList); // bulk collector
	}
}
