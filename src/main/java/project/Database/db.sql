/*
 * Creating the Database for use in the project adstod
 * For Group 5
 */
DROP DATABASE IF EXISTS adstodQuestions;  # Drop database first if it exists to prevent conflicts
CREATE DATABASE adstodQuestions;

USE adstodQuestions;                      # Make sure to indicate what database to use

CREATE TABLE Questions(                   # Table holding all questions
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionText VARCHAR(255),
  OptionCount INT(2)
);

CREATE TABLE Options(                     # Table holding all possible answers to questions
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  OptionText VARCHAR(255)
);

CREATE TABLE AnswerSets(                  # Table holding all answer sets possible for matching with results
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  AnswerOptionSet TEXT
);

CREATE TABLE PhoneNumbers(                # Table holding phone numbers for all assistance resources
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  Number VARCHAR(11)
);

CREATE TABLE AssistanceResources(         # Table holding names and links of all assistance resources that can pop up in results
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResourceName VARCHAR(255),
  Link TEXT,
  PhoneNumberID BIGINT(20),
  CONSTRAINT FOREIGN KEY (PhoneNumberID) REFERENCES PhoneNumbers(ID)
);

CREATE TABLE Results(                   # Table holding all possible results from answer sets
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResultTitle VARCHAR(255),
  AnswerSetID BIGINT(20),
  CONSTRAINT FOREIGN KEY (AnswerSetID) REFERENCES AnswerSets(ID)
);

/*
 * This table connects the AssistanceResources table to the Results table
 * Each assistance resource can pop up in multiple results
 * Each result can point to one or more assistance resources
 * This makes the connection table useful for reducing redundant data
 */
CREATE TABLE ResourcesForResults(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResultID BIGINT(20),
  AssistanceResourceID BIGINT(20),
  CONSTRAINT FOREIGN KEY (ResultID) REFERENCES Results(ID),
  CONSTRAINT FOREIGN KEY (AssistanceResourceID) REFERENCES AssistanceResources(ID)
);

/*
 * This table connects the Options table to the Questions table
 * Each question has multiple options
 * Each option can be used in multiple questions
 * This makes the connection table useful for reducing redundant data
 */
CREATE TABLE OptionsForAnswers(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20),
  OptionID BIGINT(20),
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES Questions(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES Options(ID)
);