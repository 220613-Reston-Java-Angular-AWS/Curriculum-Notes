# AWS

### Cloud / AWS Overview
* How would you describe AWS? What is "the cloud" or "cloud computing" and why is it so popular now?
  * AWS is leading cloud platform
  * Provides resources and services
  * Business benefits: no need to manage infrastructure; useful tooling; worldwide distribution/deployment
  * Downsides: locked into cloud provider
* Define Infrastructure, Platform, and Software as a Service
  * IaaS: direct access to hardware; most control
  * PaaS: hardware abstracted; developer provides the software to run
  * SaaS: software abstracted
* What's the difference between a Region and an Availability Zone (AZ)?
  * Regions cover a geographic area, all over the world
  * AZs are individual data centers; 3 AZs per region for redundancy and fault tolerance
* How are you charged for using AWS services? Does it vary by service?
  * By uptime, data stored, data exchanged
* Different ways to interact with AWS services?
  * Web console
  * AWS CLI / REST API
  * AWS SDK



  ### RDS
* What's an RDS?
  * Relational database service - a PaaS offering that loads RDBMS software based on your configuration
* Which vendors are supported?
  * Oracle, MySQL, Postgres, Amazon Aurora, MariaDB, SQLServer


  ### Other
Explain the following AWS services:
* Route 53
  * DNS (domain name service) for registering domain names like '.com' or '.net' addresses
  * Works to resolve 'somesite.come' into an IP address where your server is located
* VPN
  * Virtual Private Network - can place your cloud resources in a VPN for network security purposes
* IAM
  * Identity and Access Management - manage users, roles, and policies to provide access to your cloud resources
* ELB
  * Elastic load balancer - distribute incoming requests between different services