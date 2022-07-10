terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=3.0.0"
    }
  }
}

# Configure the Microsoft Azure Provider
provider "azurerm" {
  features {}
  client_id=var.client_id
  client_secret=var.client_secret
  subscription_id=var.subs_id
  tenant_id=var.tenant_id
}
