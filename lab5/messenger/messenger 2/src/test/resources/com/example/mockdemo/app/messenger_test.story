Given a messenger

When test connect VALID_SERVER
Then connection return 0

When test connect INVALID_SERVER
Then connection return 1

When test message is VALID_MESSAGE
Then send message return 0 or 1

When test message is INVALID_MESSAGE
Then send message return 2



