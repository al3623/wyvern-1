package wyvern.tools.parsing.coreparser.arch;

//combine with modulecheckvisitor
import java.util.HashMap;
import java.util.HashSet;

import wyvern.tools.errors.ErrorMessage;
import wyvern.tools.errors.ToolError;

public class DeclCheckVisitor extends ArchParserVisitorAdapter {
  private HashMap<String, ASTComponentTypeDecl> componentTypes = new HashMap<>();
  private HashSet<String> connectorTypes = new HashSet<>();

  private HashMap<String, String> components = new HashMap<>();
  private HashMap<String, String> connectors = new HashMap<>();

  private HashMap<String, String> entrypoints = new HashMap<>();
  private HashMap<String, HashSet<String>> attachments = new HashMap<>();

  public Object visit(ASTAttachmentDecl node, Object data) {
    String connector = node.getConnector();
    HashSet<String> ports = node.getAllPorts();
    if (!connectors.containsKey(connector)) {
      // connector not declared
      ToolError.reportError(ErrorMessage.MEMBER_NOT_DECLARED,
          node.getLocation(), "connector", connector);
    }
    if (attachments.putIfAbsent(connector, ports) != null) {
      // duplicate connector use
      ToolError.reportError(ErrorMessage.DUPLICATE_CONNECTOR_USE,
          node.getLocation(), connector);
    }

    /* Check if ports are improperly declared */
    for (String portFull : ports) {
      String[] portParts = portFull.split("\\.", 2);
      String component = portParts[0];
      String port = portParts[1];
      // check component declaration exists
      // get component type
      String type = components.get(component);
      if (type == null) {
        ToolError.reportError(ErrorMessage.MEMBER_NOT_DECLARED,
            node.getLocation(), "component", component);
      }
      // check component of that type has port
      ASTComponentTypeDecl typeDecl = componentTypes
          .get(components.get(component));
      if (!typeDecl.getReqs().containsKey(port)
          && !typeDecl.getProvs().containsKey(port)) {
        ToolError.reportError(ErrorMessage.MEMBER_NOT_DECLARED,
            node.getLocation(), "port", port);
      }

    }
    return super.visit(node, data);
  }

  public Object visit(ASTEntryPointDecl node, Object data) {
    entrypoints.put(node.getName(), node.getAction());
    return super.visit(node, data);
  }

  public Object visit(ASTComponentDecl node, Object data) {
    String name = node.getName();
    String type = node.getType();
    if (!componentTypes.containsKey(type)) {
      // component type not declared
      ToolError.reportError(ErrorMessage.ARCH_TYPE_NOT_DEFINED,
          node.getLocation(), "component", type);
    }
    if (components.putIfAbsent(name, type) != null) {
      // duplicate members
      ToolError.reportError(ErrorMessage.DUPLICATE_MEMBER_NAMES,
          node.getLocation(), name);
    }
    return super.visit(node, data);
  }

  public Object visit(ASTConnectorDecl node, Object data) {
    String name = node.getName();
    String type = node.getType();
    if (!connectorTypes.contains(type)) {
      // connector type not declared
      ToolError.reportError(ErrorMessage.ARCH_TYPE_NOT_DEFINED,
          node.getLocation(), "connector", type);
    }
    if (connectors.putIfAbsent(name, type) != null) {
      // duplicate members
      ToolError.reportError(ErrorMessage.DUPLICATE_MEMBER_NAMES,
          node.getLocation(), name);
    }
    return super.visit(node, data);
  }

  public Object visit(ASTComponentTypeDecl node, Object data) {
    if (componentTypes.containsKey(node.getTypeName())) {
      // type of this name has already been declared
      ToolError.reportError(ErrorMessage.DUPLICATE_TYPE_DEFINITIONS,
          node.getLocation(), node.getTypeName());
    }
    node.collectPorts();
    if (!node.checkModule()) {
      // module def not found HANDLED IN CHECKMODULE
    } else {
      componentTypes.put(node.getTypeName(), node);
    }
    return super.visit(node, data);
  }

  public Object visit(ASTConnectorTypeDecl node, Object data) {
    if (connectorTypes.contains(node.getTypeName())) {
      // type of this name has already been declared
      ToolError.reportError(ErrorMessage.DUPLICATE_TYPE_DEFINITIONS,
          node.getLocation(), node.getTypeName());
    }
    node.collectVals();
    if (!node.checkModule()) {
      // module not found HANDLED IN CHECKMODULE
    } else {
      connectorTypes.add(node.getTypeName());
    }
    return super.visit(node, data);
  }

}