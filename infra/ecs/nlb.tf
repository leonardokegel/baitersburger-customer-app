resource "aws_lb" "this" {
  name               = "${var.app_name}-nlb"
  internal           = true
  load_balancer_type = "network"
  subnets            = data.aws_subnets.default.ids

  tags = {
    Name = "${var.app_name}-nlb"
  }
}

resource "aws_lb_target_group" "this" {
  name        = "${var.app_name}-tg"
  port        = var.container_port #
  protocol    = "TCP"
  vpc_id      = data.aws_vpc.default.id #
  target_type = "ip"

  health_check {
    enabled             = true
    protocol            = "TCP"
    interval            = 30
    healthy_threshold   = 3
    unhealthy_threshold = 3
  }
}

resource "aws_lb_listener" "this" {
  load_balancer_arn = aws_lb.this.arn
  port              = var.container_port
  protocol          = "TCP"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.this.arn
  }
}

resource "aws_api_gateway_vpc_link" "this" {
  name        = "${var.app_name}-vpc-link"
  target_arns = [aws_lb.this.arn]
}