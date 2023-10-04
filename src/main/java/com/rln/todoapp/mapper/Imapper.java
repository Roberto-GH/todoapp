package com.rln.todoapp.mapper;

public interface Imapper <In, Out> {

  Out map(In in);

}
