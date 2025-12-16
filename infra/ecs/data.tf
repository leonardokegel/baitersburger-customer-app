data "aws_iam_role" "lab_role" {
  name = var.role_name
}

data "aws_vpc" "vpc_default" {
  default = true
}

data "aws_subnets" "aws_subnets_default" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.vpc_default.id]
  }
}

data "aws_secretsmanager_secret" "rds" {
  name = var.db_secret_name
}

data "aws_lb_target_group" "customer_lb_target_group" {
  name = "baitersburger-alb-tg"
}