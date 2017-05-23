./gradlew fatJar
jarfile="$(ls ./ktalks-core/build/libs/ | sort -n -r | head -1)"
java -jar ./ktalks-core/build/libs/$jarfile