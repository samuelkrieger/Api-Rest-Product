package br.com.samuel.api.service;

public interface Mapper<A, B> {

    B map(A input);
}