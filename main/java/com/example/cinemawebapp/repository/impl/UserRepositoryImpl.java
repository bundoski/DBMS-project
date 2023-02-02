//package com.example.cinemawebapp.repository.impl;
//
//import com.example.cinemawebapp.bootstrap.DataHolder;
//import com.example.cinemawebapp.model.User;
//
//import java.util.List;
//import java.util.Optional;
//
//public class UserRepositoryImpl {
//
//    public List<User> findAll(){
//        return DataHolder.userList;
//    }
//
//    public Optional<User> findById(Long userId) {
//        return DataHolder.userList
//                .stream()
//                .filter(i -> i.getId().equals(userId))
//                .findFirst();
//    }
//
//    public void deleteById(Long userId) {
//        DataHolder.userList.removeIf(i -> i.getId().equals(userId));
//    }
//
//    public User saveOrUpdate(User user, Long id) {
//        if (id != null) {
//            DataHolder.userList.removeIf(i -> i.getId().equals(id));
//        }
//        DataHolder.userList.add(user);
//        return  user;
//    }
//}
