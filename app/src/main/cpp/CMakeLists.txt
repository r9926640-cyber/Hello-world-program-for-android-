cmake_minimum_required(VERSION 3.22.1)
project("helloworld")

add_library(helloworld SHARED native-lib.cpp)
find_library(log-lib log)
target_link_libraries(helloworld ${log-lib})
