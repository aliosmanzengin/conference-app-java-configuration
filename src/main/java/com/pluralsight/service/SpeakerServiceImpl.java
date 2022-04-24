package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


// -Dspring.profiles.active=dev
@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    private SpeakerRepository repository;

    public SpeakerServiceImpl (){
        System.out.println("SpeakerServiceImpl no args constructor");
    }

//    @Autowired --> to switch constructor injection
    public SpeakerServiceImpl (SpeakerRepository speakerRepository){
        System.out.println("SpeakerServiceImpl repository constructor");
        repository = speakerRepository;
    }

    @PostConstruct
    private void initialize(){
        System.out.println("we're called after the constructors");
    }

    public List<Speaker> findAll(){
        return repository.findAll();
    }

    //autowired setter injection
//    @Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }

}
