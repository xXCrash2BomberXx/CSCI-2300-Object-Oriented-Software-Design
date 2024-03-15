gradle clean
git add .
git commit -m "Swapping 2.5 & 3"
git push --set-upstream origin deliverable3
git checkout main
git pull
git merge deliverable3
git push
git checkout deliverable3
