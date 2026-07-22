#!/bin/bash

cd ~/Downloads/Code/Java/Woody-Vault
javac -d out src/WoodyAPP/*.java
java -cp out WoodyAPP.WoodyVault
