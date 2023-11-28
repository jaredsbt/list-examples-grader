CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

# rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ -f 'student-submission/ListExamples.java' ]]
    then
        echo "Correct file. Moved to grading-area"
        cp "student-submission/ListExamples.java" "grading-area"
        cp "TestListExamples.java" "grading-area"
else
    echo "Incorrect file type. Must be java"
    exit 1
fi

cd grading-area

javac -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar *.java
java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > output.txt


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

# java TestListExamples1 > output.txt
