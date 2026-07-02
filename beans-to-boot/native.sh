#!/usr/bin/env bash

./mvnw -DskipTests -Pnative native:compile -Dnative.mainClass=com.example.beans_to_boot.boot.Main
