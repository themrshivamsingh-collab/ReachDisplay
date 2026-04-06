#!/usr/bin/env bash

# Gradle Wrapper script for Unix systems.

# Redirect output to the log file.
GRADLE_USER_HOME="$HOME/.gradle"
[ -d "$GRADLE_USER_HOME" ] || mkdir -p "$GRADLE_USER_HOME"

# Determine Gradle version and launch Gradle wrapper.
if [ -z "$GRADLE_VERSION" ]; then
    GRADLE_VERSION=6.8.3  # Change this to the desired version.
fi

if [ ! -f "gradle/wrapper/gradle-wrapper.jar" ]; then
    echo "Gradle wrapper JAR not found. Please set up your project correctly."
    exit 1
fi

# Execute Gradle
exec java -jar gradle/wrapper/gradle-wrapper.jar "$@"