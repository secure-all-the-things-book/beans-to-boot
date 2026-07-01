package com.example.beans_to_boot.boot;

import org.springframework.data.annotation.Id;

record Dog(@Id int id, String name, String description) {
}
