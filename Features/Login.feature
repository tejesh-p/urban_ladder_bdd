Feature: Complete Homepage 

Scenario: check if the title has urban ladder in it
Given Initialize the browser with chrome_123
And navigate to website url
When when the page loads
Then check the title has "urban ladder" in it

Scenario Outline: check login page
Given nitialize the browser with chrome
And navigate to website url
When click on login link 
When User enters invalid  and <password> clicks on login
Then Should login to the site

Examples:
|mailid                |password      |
|random@gmail.com      |randompswrd   |



Scenario Outline: check the search bar
Given Initialize the browser with chrome
And navigate to website url
When enter an <item> in search bar and clicked on search
Then should navigate to results page

Examples:
|item   |
|sofa   |

Scenario: Check if the subscribe is working
Given Initialize the browser with chrome
And navigate to website url
When given a mailid and clicked on subscribe
Then should reply saying it successful

Scenario: Check the numbe of offers in the homepage is given number
Given Initialize the browser with chrome
And navigate to website url
When the website opens 
Then check if the number of offers is "2"


Scenario: Check number items in furniture range is a
Given Initialize the browser with chrome
And navigate to website url
When the webpage opens
Then Count the number of items in furniture range is "21"

Scenario: Check there's a head alert
Given Initialize the browser with chrome
And navigate to website url
When the webpage opens
Then check if there's a head alert

Scenario: check if the instagram profile is accessible
Given Initialize the browser with chrome
And navigate to website url
When clicked on instagram icon
Then should open instagram profile in new tab

Scenario: check if websites google play app download link is working
Given Initialize the browser with chrome
And navigate to website url
When clicked on download in google play
Then should open the app in google playstore website

Scenario: check if websites app store app download link is working
Given Initialize the browser with chrome
And navigate to website url
When clicked on download in app store
Then should open the app in app store website

Scenario Outline: check if it accepts visa or other payments
Given Initialize the browser with chrome
And navigate to website url
When the site opens
Then check if the <method> payment option is available

Examples:
|method      |
|visa        |
|mastercard  |
|upi         |


Scenario Outline: check if it delivers in the given locations
Given Initialize the browser with chrome
And navigate to website url
When the site opens
Then check if the company delivers in <location>
Examples:
|location   |
|amritsar   |
|agra       |
|ahmedabad  |

