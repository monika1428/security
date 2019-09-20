package com.example.security;

import com.example.security.services.StreamService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {

	@Autowired
	private StreamService streamService;

	private List<String> names = new ArrayList<>();

	@Before
	public void prepareNameList() {
		names.add("Jan");
		names.add("Adam");
		names.add("Jan");
		names.add("Kazimierz");
		names.add("Olaf");
		names.add("Bogdan");

	}

	@Test
	public void testSortByNameLength() {
		List <Integer>sortedNamesLength = streamService.sortByNameLength(names);
		Assert.assertTrue(sortedNamesLength.get(0) == 3);
		Assert.assertTrue(sortedNamesLength.get(1) == 3);
		Assert.assertTrue(sortedNamesLength.get(2) == 4);
		Assert.assertTrue(sortedNamesLength.get(3) == 4);
		Assert.assertTrue(sortedNamesLength.get(4) == 6);
		Assert.assertTrue(sortedNamesLength.get(5) == 9);
	}

	@Test
	public void testSortByLongerName() {
		List <String>sortedNamesLength = streamService.sortByLongerName(names);
		Assert.assertTrue(sortedNamesLength.get(0) == "Jan");
		Assert.assertTrue(sortedNamesLength.get(1) == "Jan");
		Assert.assertTrue(sortedNamesLength.get(2) == "Adam" || sortedNamesLength.get(2) == "Olaf");
		Assert.assertTrue(sortedNamesLength.get(3) == "Adam" || sortedNamesLength.get(3) == "Olaf");
		Assert.assertTrue(sortedNamesLength.get(4) == "Bogdan");
		Assert.assertTrue(sortedNamesLength.get(5) == "Kazimierz");
	}
	@Test
	public void testSortByShorterName() {
		List <String>sortedNamesLength = streamService.sortByShorterName(names);
		Assert.assertTrue(sortedNamesLength.get(5) == "Jan");
		Assert.assertTrue(sortedNamesLength.get(4) == "Jan");
		Assert.assertTrue(sortedNamesLength.get(3) == "Adam" || sortedNamesLength.get(3) == "Olaf");
		Assert.assertTrue(sortedNamesLength.get(2) == "Adam" || sortedNamesLength.get(2) == "Olaf");
		Assert.assertTrue(sortedNamesLength.get(1) == "Bogdan");
		Assert.assertTrue(sortedNamesLength.get(0) == "Kazimierz");
	}


	@Test
	public void testSortByShorterName2() {
		List <String>sortedNamesLength = streamService.sortByShorterName(Collections.emptyList());
		Assert.assertTrue(sortedNamesLength.isEmpty());
	}



}
