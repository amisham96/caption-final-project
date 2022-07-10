resource "azurerm_resource_group" "test" {
  name     = "test-resources"
  location = "East US"
}

resource "azurerm_kubernetes_cluster" "test" {
  name                = "test-aks1"
  location            = azurerm_resource_group.test.location
  resource_group_name = azurerm_resource_group.test.name
  dns_prefix          = "testaks1"

  default_node_pool {
    name       = "default"
    node_count = 1
    vm_size    = "Standard_DS2_v2"
  }

  identity {
    type = "SystemAssigned"
  }

  tags = {
    Environment = "Production"
  }
}
