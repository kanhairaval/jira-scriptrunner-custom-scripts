# jira-scriptrunner-custom-scripts-KR

This project provides a script to update JIRA issues' custom fields automatically when specific events occur.

## Requirements

JIRA 7.0 or later
ScriptRunner for JIRA

## Installation

Download the script file custom-field-update.groovy.
In JIRA, go to Administration > Add-ons > ScriptRunner > Script Console.
Copy and paste the script into the console.
Save the script.

## Usage

In JIRA, go to Administration > Issues > Custom Fields.
Find the custom field you want to update and note its ID.
Edit the custom-field-update.groovy script and replace the values of the textFieldId and selectFieldId variables with the IDs of your custom fields.
Save the script.
Test the script by creating or updating an issue that triggers the event specified in the script.

## Troubleshooting
If you encounter any issues with the script, please check the JIRA logs for error messages.

## Contributing
Contributions to this project are welcome. Please submit a pull request or open an issue on the GitHub repository.

## Screenshot

![Screen Shot 2023-04-14 at 10 25 25 AM](https://user-images.githubusercontent.com/114125334/232072154-0d0f3baf-8702-44af-9d3a-be70aa942d89.png)

## License
This project is licensed under the MIT License - see the LICENSE file for details.
