package com.vfguille.inventory.data.repository;

import com.vfguille.inventory.data.model.Section;

import java.util.ArrayList;
import java.util.Iterator;

public class SectionRepository {
    private static SectionRepository sectionRepository;
    private ArrayList<Section> list;

    private SectionRepository(){
        list = new ArrayList<>();
        initialize();
    }

    public static SectionRepository getInstance(){
        if (sectionRepository == null)
            sectionRepository = new SectionRepository();
        return sectionRepository;
    }

    public ArrayList<Section> getList(){
        return this.list;
    }

    private void initialize() {
        list.add(new Section("Sección A", "A", "1CFGS", "Sección de los imberbes de primero.", "https://i.kym-cdn.com/photos/images/newsfeed/001/003/188/daa.jpg"));
        list.add(new Section("Sección B", "B", "2CFGS", "Los más aplicados.", "https://i.kym-cdn.com/photos/images/newsfeed/001/003/188/daa.jpg"));
        list.add(new Section("Sección C", "C", "1CFGM", "Dando ofimática con Schema.", "https://i.kym-cdn.com/photos/images/newsfeed/001/003/188/daa.jpg"));
    }

    public boolean add(Section Section) {
        if (!list.contains(Section)){
            list.add(Section);
            return true;
        }else
            return false;
    }

    public boolean edit(Section Section) {
        try {
            for (Section dependencyIt : list) {
                if (dependencyIt.getShortName().equals(Section.getShortName())) {
                    dependencyIt.setName(Section.getName());
                    dependencyIt.setDescription(Section.getDescription());
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Section Section){
        Iterator<Section> dependencyIterator = list.iterator();
        while (dependencyIterator.hasNext()){
            if (dependencyIterator.next().equals(Section)) {
                dependencyIterator.remove();
                return true;
            }
        }
        return false;
    }
}
