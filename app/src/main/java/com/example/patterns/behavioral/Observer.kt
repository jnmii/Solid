package com.example.patterns.behavioral

class Observer {
    apiService.getData(someData)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe (/* an Observer */)

}