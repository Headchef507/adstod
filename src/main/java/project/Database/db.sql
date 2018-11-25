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

CREATE TABLE PhoneNumbers(                # Table holding phone numbers for all assistance resources
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  Number VARCHAR(11) NOT NULL
);

CREATE TABLE AssistanceResources(         # Table holding names and links of all assistance resources that can pop up in results
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  Title VARCHAR(255) NOT NULL,
  Link TEXT NOT NULL
);

/*
CREATE TABLE Results(                   # Table holding all possible results from answer sets
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResultTitle VARCHAR(255) NOT NULL
);
*/
/*
CREATE TABLE AnswerSets(                  # Table holding all answer sets possible for matching with results
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  AnswerOptionSet TEXT NOT NULL,
  ResultID BIGINT(20),
  CONSTRAINT FOREIGN KEY (ResultID) REFERENCES Results(ID)
);
*/
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
/*
CREATE TABLE ResourcesForResults(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  ResultID BIGINT(20) NOT NULL,
  AssistanceResourceID BIGINT(20) NOT NULL,
  CONSTRAINT FOREIGN KEY (ResultID) REFERENCES Results(ID),
  CONSTRAINT FOREIGN KEY (AssistanceResourceID) REFERENCES AssistanceResources(ID)
);
*/

/*
 * These tables connect the Options tables to the Questions tables
 * Each questionText has multiple options
 * Each option can be used in multiple questions
 * This makes the connection tables useful for reducing redundant data
 */
CREATE TABLE OptionsForAnswersICE(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20) NOT NULL,
  OptionID BIGINT(20) NOT NULL,
  NextQuestionID BIGINT(20),
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES QuestionsICE(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES OptionsICE(ID),
  CONSTRAINT FOREIGN KEY (NextQuestionID) REFERENCES QuestionsICE(ID)
);

CREATE TABLE OptionsForAnswersENG(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20) NOT NULL,
  OptionID BIGINT(20) NOT NULL,
  NextQuestionID BIGINT(20),
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES QuestionsENG(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES OptionsENG(ID),
  CONSTRAINT FOREIGN KEY (NextQuestionID) REFERENCES QuestionsENG(ID)
);

CREATE TABLE OptionsForAnswersPOL(
  ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  QuestionID BIGINT(20) NOT NULL,
  OptionID BIGINT(20) NOT NULL,
  NextQuestionID BIGINT(20),
  CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES QuestionsPOL(ID),
  CONSTRAINT FOREIGN KEY (OptionID) REFERENCES OptionsPOL(ID),
  CONSTRAINT FOREIGN KEY (NextQuestionID) REFERENCES QuestionsPOL(ID)
);

-- Inserts
-- Inserting 2 questionText in every language
INSERT INTO QuestionsICE (QuestionText, OptionCount) VALUES ("Kyn?", 3);
INSERT INTO QuestionsENG (QuestionText, OptionCount) VALUES ("Gender?", 3);
INSERT INTO QuestionsPOL (QuestionText, OptionCount) VALUES ("PLACEHOLDER?", 3); -- Polish translation needed
INSERT INTO QuestionsICE (QuestionText, OptionCount) VALUES ("Aldursbil?", 5);
INSERT INTO QuestionsENG (QuestionText, OptionCount) VALUES ("Age range?", 5);
INSERT INTO QuestionsPOL (QuestionText, OptionCount) VALUES ("PLACEHOLDER2?", 5); -- Polish translation needed
INSERT INTO QuestionsICE (QuestionText, OptionCount) VALUES ("Hjúskaparstaða?", 3);
INSERT INTO QuestionsENG (QuestionText, OptionCount) VALUES ("Relationship Status?", 3);
INSERT INTO QuestionsPOL (QuestionText, OptionCount) VALUES ("PLACEHOLDER3?", 3); -- Polish translation needed

-- Inserting all options for 2 questionText in icelandic
INSERT INTO OptionsICE (OptionText) VALUES ("Karlkyns");
INSERT INTO OptionsICE (OptionText) VALUES ("Kvenkyns");
INSERT INTO OptionsICE (OptionText) VALUES ("Annað");
INSERT INTO OptionsICE (OptionText) VALUES ("< 18");
INSERT INTO OptionsICE (OptionText) VALUES ("18 - 35");
INSERT INTO OptionsICE (OptionText) VALUES ("35 - 50");
INSERT INTO OptionsICE (OptionText) VALUES ("50 - 67");
INSERT INTO OptionsICE (OptionText) VALUES ("> 67");
INSERT INTO OptionsICE (OptionText) VALUES ("Einhleypur");
INSERT INTO OptionsICE (OptionText) VALUES ("Sambúð");
INSERT INTO OptionsICE (OptionText) VALUES ("Kvænt/ur");

-- Inserting all options for 2 questionText in english
INSERT INTO OptionsENG (OptionText) VALUES ("Male");
INSERT INTO OptionsENG (OptionText) VALUES ("Female");
INSERT INTO OptionsENG (OptionText) VALUES ("Other");
INSERT INTO OptionsENG (OptionText) VALUES ("< 18");
INSERT INTO OptionsENG (OptionText) VALUES ("18 - 35");
INSERT INTO OptionsENG (OptionText) VALUES ("35 - 50");
INSERT INTO OptionsENG (OptionText) VALUES ("50 - 67");
INSERT INTO OptionsENG (OptionText) VALUES ("> 67");
INSERT INTO OptionsENG (OptionText) VALUES ("Single");
INSERT INTO OptionsENG (OptionText) VALUES ("Living together");
INSERT INTO OptionsENG (OptionText) VALUES ("Married");

-- Inserting all options for 2 questionText in polish
-- Translation needed
INSERT INTO OptionsPOL (OptionText) VALUES ("PHMale");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHFemale");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHOther");
INSERT INTO OptionsPOL (OptionText) VALUES ("< 18");
INSERT INTO OptionsPOL (OptionText) VALUES ("18 - 35");
INSERT INTO OptionsPOL (OptionText) VALUES ("35 - 50");
INSERT INTO OptionsPOL (OptionText) VALUES ("50 - 67");
INSERT INTO OptionsPOL (OptionText) VALUES ("> 67");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHEinhleypur");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHSambúð");
INSERT INTO OptionsPOL (OptionText) VALUES ("PHKvænt/ur");
/*
-- Inserting all possible answer sets
INSERT INTO AnswerSets (AnswerOptionSet) VALUES ("1");
INSERT INTO AnswerSets (AnswerOptionSet) VALUES ("2");
INSERT INTO AnswerSets (AnswerOptionSet) VALUES ("3");
*/
-- Inserting phone numbers for assistance resources
INSERT INTO PhoneNumbers(Number) VALUES ("+3545465645");
INSERT INTO PhoneNumbers(Number) VALUES ("+3545656565");
INSERT INTO PhoneNumbers(Number) VALUES ("+3545555555");

-- Inserting assistance resources
INSERT INTO AssistanceResources(Title, Link) VALUES ("Addi-kun", "addikun.is");
INSERT INTO AssistanceResources(Title, Link) VALUES ("Atli-chan", "atlichan.com");
INSERT INTO AssistanceResources(Title, Link) VALUES ("Tommi-san", "tommisan.po");
/*
-- Inserting results
INSERT INTO Results(ResultTitle) VALUES ("Male gender");
INSERT INTO Results(ResultTitle) VALUES ("Female gender");
INSERT INTO Results(ResultTitle) VALUES ("Other gender");
*/
-- Connecting phone numbers to assistance resources
INSERT INTO PhoneNumbersForResources(PhoneNumberID, AssistanceResourceID) VALUES (1, 1);
INSERT INTO PhoneNumbersForResources(PhoneNumberID, AssistanceResourceID) VALUES (2, 2);
INSERT INTO PhoneNumbersForResources(PhoneNumberID, AssistanceResourceID) VALUES (3, 3);
/*
-- Connecting assistance resources to results
INSERT INTO ResourcesForResults(ResultID, AssistanceResourceID) VALUES (1, 1);
INSERT INTO ResourcesForResults(ResultID, AssistanceResourceID) VALUES (2, 2);
INSERT INTO ResourcesForResults(ResultID, AssistanceResourceID) VALUES (3, 3);
*/
-- Connecting the questions to options and the next questionText in line
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (1, 1, 2);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (1, 2, 2);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (1, 3, 2);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (2, 4, 3);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (2, 5, 3);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (2, 6, 3);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (2, 7, 3);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (2, 8, 3);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (3, 9, 1);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (3, 10, 1);
INSERT INTO OptionsForAnswersICE (QuestionID, OptionID, NextQuestionID) VALUES (3, 11, 1);

INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (1, 1, 2);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (1, 2, 2);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (1, 3, 2);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (2, 4, 3);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (2, 5, 3);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (2, 6, 3);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (2, 7, 3);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (2, 8, 3);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (3, 9, 1);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (3, 10, 1);
INSERT INTO OptionsForAnswersENG (QuestionID, OptionID, NextQuestionID) VALUES (3, 11, 1);

INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (1, 1, 2);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (1, 2, 2);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (1, 3, 2);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (2, 4, 3);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (2, 5, 3);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (2, 6, 3);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (2, 7, 3);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (2, 8, 3);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (3, 9, 1);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (3, 10, 1);
INSERT INTO OptionsForAnswersPOL (QuestionID, OptionID, NextQuestionID) VALUES (3, 11, 1);
