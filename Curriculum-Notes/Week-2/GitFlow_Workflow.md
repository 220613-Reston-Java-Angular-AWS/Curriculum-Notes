# Git Flow (a.k.a GitFlow Workflow)
Some of our more complex web applications call for a more complex workflow. For those project, we use Git Flow.  

Git Flow Workflow is a Git workflow design that was first published and made popular by [Vincent Driessen at nvie](https://nvie.com/posts/a-successful-git-branching-model/). Gitflow Workflow is a **robust framework for managing larger projects** by defining a strict branching model designed around project release.

> Git Flow works very well for packaged software that is downloaded by users, such as libraries and desktop applications.

### Git Flow vs. GitHub Flow
Git Flow Workflow is not to be confused with **GitHub Flow** which is a simplified alternative - Git**Hub** Flow is the standard model of branching that junior programmers are familiar with.  

* Git**Hub** Flow is a lightweight, branch-based workflow that supports teams and projects where deployments are made regularly.

* **Git Flow layers additional complexity ontop of GitHub Flow**. 

* In **Git Flow**, new development (such as features and non-emergency bug fixes) is done in **feature branches**, and is only merged back into main body of code when the developer(s) is happy that the code is ready for release.

    - This differs from the traditional Git**Hub** Workflow model in that the master branch is where only version releases of the software is pushed.  Otherwise, most of the deployable code is pushed to a release branch.

## How to Use Git Flow
The git-flow toolset is an actual command line tool that has an installation process. 

#### Windows
Open Git Bash and run the following command:
```
$ git flow init
```

#### Mac OS
```
$ brew install git-flow
```

## How it Works:

1.  All new development is built in **feature branches**.

<img src="./images/gitflow-1.png">

2. When the features are complete, they are merged into the **develop branch** for release.

<img src="./images/gitflow-2.png">

3. When it is time for a release, all features and fixes are moved from features to **release branch** .

<img src="./images/gitflow-3.png">

> The code in the release branch is deployed onto a suitable test environment, tested, and any problems are fixed directly in the release branch. This `deploy -> test -> fix -> redeploy -> retest` cycle continues until you’re happy that the release is good enough to release to end users.

4. When the release is finalized, the release branch is merged into **master** *and* into **develop** so that none of the changes made in **release branch** are lost.

<img src="./images/gitflow-4.png">

5. The master branch tracks released code only. The only commits to master are merges from release branches and **hotfix branches**.  **Hotfix branches** are used to create emergency fixes:

<img src="./images/gitflow-5.png">