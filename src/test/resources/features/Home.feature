@AUTOMATED
Feature: Home

  @branding
  Scenario Outline: Verificar componentes de Home para "<boton>"
    Given el usuario ingresa a la home
    Then el usuario verifica que el encabezado es correcto
    And el usuario verifica que el titulo " Selecciona el tipo de daño sufrido " es correcto
    And el usuario verifica que el boton "<boton>" es correcto
    Then el usuario verifica que los elementos del footer son visibles y correctos
    Examples:
      | boton            |
      | Daños Materiales |
      | Lesiones         |
      | Otros            |

  @branding
  Scenario Outline: Verificar componentes de "<boton>"
    Given el usuario ingresa a la home
    When el usuario selecciona "<boton>"
    Then el usuario verifica que el titulo " Es necesario tener esta documentación a mano antes de realizar el reclamo:" es correcto
    And el usuario verifica que la descripcion de "<boton>" es correcta
    And el usuario verifica que el boton "Continuar" de "<boton>" es correcto
    Examples:
      | boton            |
      | Daños Materiales |
      | Lesiones         |
      | Otros            |

  @branding
  Scenario Outline: Verificar campos de "<boton>"
    Given el usuario ingresa a la home
    When el usuario selecciona "<boton>"
    And el usuario hace clic en "Continuar"
    Then el usuario verifica que el titulo "<boton>" de "<boton>" es correcto
    Then el usuario verifica que el titulo " Identificación del siniestro" es correcto
    Then el usuario verifica que el campo "Patente de asegurado de BARBUSS" es correcto
    And el usuario verifica que el campo "Fecha de Siniestro" es correcto
    And el usuario verifica que el boton "Volver" de "<boton>" es correcto
    And el usuario verifica que el boton "Buscar" de "<boton>" es correcto
    Examples:
      | boton            |
      | Daños Materiales |
      | Lesiones         |
      | Otros            |

  @functional @branding
  Scenario Outline: Validar mensaje de error en búsqueda de "<boton>"
    Given el usuario ingresa a la home
    When el usuario selecciona "<boton>"
    And el usuario hace clic en "Continuar"
    And el usuario ingresa un dato en el campo "Patente de asegurado de BARBUSS"
    And el usuario ingresa un dato en el campo "Fecha de Siniestro"
    And el usuario hace clic en "Buscar"
    Then el usuario verifica que el mensaje de error es correcto
    And el usuario verifica que el boton "Aceptar" de "<boton>" es correcto
    And el usuario hace clic en "Aceptar"
    Examples:
      | boton            |
      | Daños Materiales |
      | Lesiones         |
      | Otros            |

  @functional @branding
  Scenario Outline: Validar búsqueda correcta en "<boton>"
    Given el usuario ingresa a la home
    When el usuario selecciona "<boton>"
    And el usuario hace clic en "Continuar"
    And el usuario ingresa un dato correcto en el campo "Patente de asegurado de BARBUSS" en "<boton>"
    And el usuario ingresa un dato correcto en el campo "Fecha de Siniestro" en "<boton>"
    And el usuario hace clic en "Buscar"
    Then el usuario verifica que el sistema muestra el resultado de búsqueda correctamente para "<boton>"
    Examples:
      | boton            |
      | Daños Materiales |
      | Lesiones         |
      | Otros            |