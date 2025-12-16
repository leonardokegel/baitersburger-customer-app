data "aws_iam_role" "lab_role" {
  name = var.role_name
}

data "aws_vpc" "default" {
  default = true
}

data "aws_subnets" "default" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }

  filter {
    name   = "default-for-az"
    values = ["true"]
  }
}

data "aws_security_group" "default" {
  name   = "default"
  vpc_id = data.aws_vpc.default.id
}

data "aws_secretsmanager_secret" "rds" {
  name = var.db_secret_name
}

#data "aws_lb_target_group" "customer" {
#  name = "baitersburger-alb-tg"
#}
