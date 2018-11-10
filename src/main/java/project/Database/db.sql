/*
 * Creating the Database for use in the project adstod
 * For Group 5
 */
DROP DATABASE IF EXISTS adstodQuestions;  # Drop database first if it exists to prevent conflicts
CREATE DATABASE adstodQuestions;

USE adstodQuestions;                      # Make sure to indicate what database to use

CREATE TABLE QuestionsICE(                   # Table holding all questions in icelandic
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionText VARCHAR(255) NOT NULL,
  OptionCount INT(2) NOT NULL
);

CREATE TABLE QuestionsENG(                   # Table holding all questions in english
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionText VARCHAR(255) NOT NULL,
  OptionCount INT(2) NOT NULL
);

CREATE TABLE QuestionsPOL(                   # Table holding all questions in polish
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionText VARCHAR(255) NOT NULL,
  OptionCount INT(2) NOT NULL
);

CREATE TABLE OptionsICE(                     # Table holding all possible answers to questions
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  OptionText VARCHAR(255) NOT NULL
);

CREATE TABLE OptionsENG(                     # Table holding all possible answers to questions
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  OptionText VARCHAR(255) NOT NULL
);

CREATE TABLE OptionsPOL(                     # Table holding all possible answers to questions
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  OptionText VARCHAR(255) NOT NULL
);

CREATE TABLE AnswerSets(                  # Table holding all answer sets possible for matching with results
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  AnswerOptionSet TEXT NOT NULL
);

CREATE TABLE PhoneNumbers(                # Table holding phone numbers for all assistance resources
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  Number VARCHAR(11) NOT NULL
);

CREATE TABLE AssistanceResources(         # Table holding names and links of all assistance resources that can pop up in results
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResourceName VARCHAR(255) NOT NULL,
  Link TEXT NOT NULL
);

CREATE TABLE Results(                   # Table holding all possible results from answer sets
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResultTitle VARCHAR(255) NOT NULL,
  AnswerSetID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (AnswerSetID) REFERENCES AnswerSets(ID)
);

/**
 * This table connects the PhoneNumbers table to the AssistanceResources table
 * Each assistance resource can have many phone numbers
 * Each phone number can belong to multiple assistance resources
 * This makes the connection table useful for reducing redundant data
 */
CREATE TABLE PhoneNumbersForResources(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  PhoneNumberID BIGINT(20) NOT NULL,
  AssistanceResourceID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (PhoneNumberID) REFERENCES PhoneNumbers(ID),
  CONSTRAINT FOREIGN KEY (AssistanceResourceID) REFERENCES AssistanceResources(ID)
);

/*
 * This table connects the AssistanceResources table to the Results table
 * Each assistance resource can pop up in multiple results
 * Each result can point to one or more assistance resources
 * This makes the connection table useful for reducing redundant data
 */
CREATE TABLE ResourcesForResults(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResultID BIGINT(20) NOT NULL,
  AssistanceResourceID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (ResultID) REFERENCES Results(ID),
  CONSTRAINT FOREIGN KEY (AssistanceResourceID) REFERENCES AssistanceResources(ID)
);

/*
 * These tables connect the Options tables to the Questions tables
 * Each question has multiple options
 * Each option can be used in multiple questions
 * This makes the connection tables useful for reducing redundant data
 */
CREATE TABLE OptionsForAnswersICE(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20) NOT NULL,
  OptionID BIGINT(20) NOT NULL,
  NextQuestionID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES QuestionsICE(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES OptionsICE(ID),
  CONSTRAINT FOREIGN KEY (NextQuestionID) REFERENCES QuestionsICE(ID)
);

CREATE TABLE OptionsForAnswersENG(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20) NOT NULL,
  OptionID BIGINT(20) NOT NULL,
  NextQuestionID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES QuestionsENG(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES OptionsENG(ID),
  CONSTRAINT FOREIGN KEY (NextQuestionID) REFERENCES QuestionsENG(ID)
);

CREATE TABLE OptionsForAnswersPOL(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20) NOT NULL,
  OptionID BIGINT(20) NOT NULL,
  NextQuestionID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES QuestionsPOL(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES OptionsPOL(ID),
  CONSTRAINT FOREIGN KEY (NextQuestionID) REFERENCES QuestionsPOL(ID)
);

-- Inserts
INSERT INTO QuestionsICE (QuestionText, OptionCount) VALUES ("Kyn?", 3);
INSERT INTO QuestionsENG (QuestionText, OptionCount) VALUES ("Gender?", 3);
INSERT INTO QuestionsPOL (QuestionText, OptionCount) VALUES ("PLACEHOLDER?", 3);

INSERT INTO OptionsICE (OptionText) VALUES ("Karlkyns");
INSERT INTO OptionsICE (OptionText) VALUES ("Kvenkyns");
INSERT INTO OptionsICE (OptionText) VALUES ("Annað");

INSERT INTO OptionsENG (OptionText) VALUES ("Male");
INSERT INTO OptionsENG (OptionText) VALUES ("Female");
INSERT INTO OptionsENG (OptionText) VALUES ("Other");

INSERT INTO OptionsPOL (OptionText) VALUES ("PHMale");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHFemale");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHOther");

INSERT INTO AnswerSets (AnswerOptionSet) VALUES ("1");
INSERT INTO AnswerSets (AnswerOptionSet) VALUES ("2");
INSERT INTO AnswerSets (AnswerOptionSet) VALUES ("3");

INSERT INTO PhoneNumbers(Number) VALUES ("+3545465645");
INSERT INTO PhoneNumbers(Number) VALUES ("+3545656565");
INSERT INTO PhoneNumbers(Number) VALUES ("+3545555555");

INSERT INTO AssistanceResources(ResourceName, Link) VALUES ("Addi-kun", "addikun.is");
INSERT INTO AssistanceResources(ResourceName, Link) VALUES ("Atli-chan", "atlichan.com");
INSERT INTO AssistanceResources(ResourceName, Link) VALUES ("Tommi-san", "tommisan.po");

INSERT INTO Results(ResultTitle, AnswerSetID) VALUES ("Male gender", 1);
INSERT INTO Results(ResultTitle, AnswerSetID) VALUES ("Female gender", 2);
INSERT INTO Results(ResultTitle, AnswerSetID) VALUES ("Other gender", 3);

INSERT INTO PhoneNumbersForResources(PhoneNumberID, AssistanceResourceID) VALUES (1, 1);
INSERT INTO PhoneNumbersForResources(PhoneNumberID, AssistanceResourceID) VALUES (2, 2);
INSERT INTO PhoneNumbersForResources(PhoneNumberID, AssistanceResourceID) VALUES (3, 3);

INSERT INTO ResourcesForResults(ResultID, AssistanceResourceID) VALUES (1, 1);
INSERT INTO ResourcesForResults(ResultID, AssistanceResourceID) VALUES (2, 2);
INSERT INTO ResourcesForResults(ResultID, AssistanceResourceID) VALUES (3, 3);

INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (1, 1, 0);

INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (1, 1, 0);

INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (1, 1, 0);