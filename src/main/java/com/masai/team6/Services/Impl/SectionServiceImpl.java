package com.masai.team6.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.team6.Entities.Batch;
import com.masai.team6.Entities.Section;
import com.masai.team6.Exception.ResourceNotFoundException;
import com.masai.team6.Payloads.BatchDto;
import com.masai.team6.Payloads.SectionDto;
import com.masai.team6.Repository.SectionRepo;
import com.masai.team6.Services.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionRepo sectionRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SectionDto saveSection(SectionDto sectionDto) {
		Section section = this.modelMapper.map(sectionDto, Section.class);
		sectionRepo.save(section);

		return this.modelMapper.map(section, SectionDto.class);
	}

	@Override
	public List<SectionDto> MySections() {

		List<Section> SectionListing = sectionRepo.findAll();

		List<SectionDto> SectionDtos = SectionListing.stream().map(section -> this.modelMapper.map(section, SectionDto.class))
				.collect(Collectors.toList());
		return SectionDtos;
	}

	@Override
	public SectionDto deleteSection(Integer id) {
		Section section = sectionRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Section", "id", id));
		sectionRepo.delete(section);
		
		return this.modelMapper.map(section, SectionDto.class);
		
	}

}
