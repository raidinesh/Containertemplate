#encoding: utf-8


require 'addressable'
require 'rest-client'
require 'json'
require 'ocpm_spring_helper'

####################
# Given Statements #
####################

Given(/^the app is running$/) do
    Response = RestClient.get "http://#{HOST}:#{PORT}/health", {:accept => :json}
    Response.code == 200
    jsonHash = JSON.parse(Response)
    status = jsonHash["status"]
    status == "UP"
end



###################
# When Statements #
###################


When(/^I query the version$/) do 
    @version = OcpmSpringHelper.getVersion "#{HOST}", "#{PORT}"
end



###################
# Then statements #
###################
Then(/^the version should be "([^"]*)"$/) do |hello|
    hello==@version ? next : abort("#{hello} does not match #{@version}")
end









