#!/bin/sh

git filter-branch --env-filter '

OLD_EMAIL="DailyEfforts@gmail.com"
# OLD_EMAIL="vhow@qq.com"
CORRECT_NAME="vhow"
CORRECT_EMAIL="vhow@163.com"

if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_AUTHOR_NAME="$CORRECT_NAME"
    export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags

# git push --force --tags origin 'refs/heads/*'