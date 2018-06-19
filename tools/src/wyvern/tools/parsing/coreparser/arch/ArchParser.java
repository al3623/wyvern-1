/* Generated By:JJTree&JavaCC: Do not edit this line. ArchParser.java */
package wyvern.tools.parsing.coreparser.arch;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import wyvern.tools.arch.lexing.ArchLexer;
import java.io.FileNotFoundException;
import java.io.IOException;
import edu.umn.cs.melt.copper.runtime.logging.CopperParserException;
import wyvern.tools.parsing.coreparser.WyvernTokenManager;
import wyvern.tools.parsing.coreparser.TokenManager;
import wyvern.tools.parsing.coreparser.Token;
import wyvern.tools.parsing.coreparser.ParseException;

public class ArchParser/*@bgen(jjtree)*/implements ArchParserTreeConstants, ArchParserConstants {/*@bgen(jjtree)*/
  protected JJTArchParserState jjtree = new JJTArchParserState();
    public static String kindToName(int kind) {
      switch (kind) {
      case MULTI_LINE_COMMENT: return "MULTI_LINE_COMMENT";
      case COMMA: return "COMMA";
      case ATTACHMENTS: return "ATTACHMENTS";
      case IS: return "IS";
      case BINDINGS: return "BINDINGS";
      case ENTRYPOINTS: return "ENTRYPOINTS";
      case CONNECT: return "CONNECT";
      case DOT: return "DOT";
      case AND: return "AND";
      case WITH: return "WITH";
      case CONNECTORS: return "CONNECTORS";
      case COMPONENTS: return "COMPONENTS";
      case ARCHITECTURE: return "ARCHITECTURE";
      case VAL: return "VAL";
      case CONNECTOR: return "CONNECTOR";
      case COMPONENT: return "COMPONENT";
      case PORT: return "PORT";
      case COLON: return "COLON";
      case IDENTIFIER: return "IDENTIFIER";
      case WHITESPACE: return "WHITESPACE";
      case DEDENT: return "DEDENT";
      case INDENT: return "INDENT";
      case NEWLINE: return "NEWLINE";
      case PROVIDES: return "PROVIDES";
      case REQUIRES: return "REQUIRES";
      default: return "UNKNOWN(" + kind + ")";
      }
    }

    public static void main(String []args) throws CopperParserException, IOException, FileNotFoundException {
        String root = System.getProperty("user.dir");
        File example1, example2, example3;
        if (root.substring(root.length() - 5).equals("tools"))  {
          example1 = new File(root + "/../examples/architecture/example1.wyc");
          example2 = new File(root + "/../examples/architecture/example2.wyc");
          example3 = new File(root + "/../examples/architecture/example3.wyc");
        } else  {
          example1 = new File(root + "/../../examples/architecture/example1.wyc");
          example2 = new File(root + "/../../examples/architecture/example2.wyc");
          example3 = new File(root + "/../../examples/architecture/example3.wyc");
        }
        BufferedReader source = new BufferedReader(new FileReader(
                                                                  //    example1
                                                                      example2
                                                                  //    example3
                                                                    ));
        ArchParser wp = new ArchParser(
                (TokenManager) new WyvernTokenManager<ArchLexer, ArchParserConstants>(source, "test", ArchLexer.class,
                        ArchParserConstants.class));

        /*Full list of tokens as collected by the token manager
        List<Token> tokens = new ArchLexer().parse(source, "test");
        for (Token t: tokens) {
          if (!kindToName(t.kind).equals("WHITESPACE")){
            System.out.println(kindToName(t.kind));
          }
        }*/

        //Parsing attempt
        try {
          wp.ArchDesc();
        } catch (ParseException e)  {
          e.printStackTrace();
        }

        /*What's left after parsing attempt*/
        Token t = wp.getNextToken();
        while (!kindToName(t.kind).equals("UNKNOWN(0)")){
            System.out.println(kindToName(t.kind));
            t = wp.getNextToken();
        }

        System.out.println("~PARSING DONE~");

    }

/** Root production. */
  final public void ArchDesc() throws ParseException {
  Node exp;
    exp = ArchTypeDeclSeq();
  }

  final public Node ArchTypeDeclSeq() throws ParseException {
 /*@bgen(jjtree) ArchTypeDeclSeq */
  ASTArchTypeDeclSeq jjtn000 = new ASTArchTypeDeclSeq(JJTARCHTYPEDECLSEQ);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Node ast1; Node ast2;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPONENT:
      case EXTERNAL:
      case CONNECTOR:
      case ARCHITECTURE:
        ast1 = ArchTypeDecls();
        label_1:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMPONENT:
          case EXTERNAL:
          case CONNECTOR:
          case ARCHITECTURE:
            ;
            break;
          default:
            jj_la1[0] = jj_gen;
            break label_1;
          }
          ast2 = ArchTypeDecls();

        }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
        break;
      case 0:
        jj_consume_token(0);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ArchTypeDecls() throws ParseException {
  Node exp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMPONENT:
    case EXTERNAL:
      exp = ComponentTypeDecl();
                                      {if (true) return null;}
      break;
    case CONNECTOR:
      exp = ConnectorTypeDecl();
                                      {if (true) return null;}
      break;
    case ARCHITECTURE:
      exp = ArchitectureTypeDecl();
                                      {if (true) return null;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ComponentTypeDecl() throws ParseException {
 /*@bgen(jjtree) ComponentTypeDecl */
  ASTComponentTypeDecl jjtn000 = new ASTComponentTypeDecl(JJTCOMPONENTTYPEDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name; boolean isExternal; Node exp1; Node exp2;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EXTERNAL:
        jj_consume_token(EXTERNAL);
                   isExternal=true;
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      jj_consume_token(COMPONENT);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      exp1 = ComponentTypeDeclBody();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMPONENT:
        case EXTERNAL:
        case PORT:
        case CONNECTOR:
        case VAL:
        case ARCHITECTURE:
        case BINDINGS:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_2;
        }
        exp2 = ComponentTypeDeclBody();

      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ComponentTypeDeclBody() throws ParseException {
  Node ast1; Node ast2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PORT:
    case VAL:
      ast1 = MemberDecls();
                                      {if (true) return null;}
      break;
    case COMPONENT:
    case EXTERNAL:
    case CONNECTOR:
    case ARCHITECTURE:
      ast1 = ArchTypeDecls();
                                      {if (true) return null;}
      break;
    case BINDINGS:
      ast1 = BindingDecls();
                                      {if (true) return null;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ConnectorTypeDecl() throws ParseException {
 /*@bgen(jjtree) ConnectorTypeDecl */
  ASTConnectorTypeDecl jjtn000 = new ASTConnectorTypeDecl(JJTCONNECTORTYPEDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name; Node exp1; Node exp2;
    try {
      jj_consume_token(CONNECTOR);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      exp1 = ValDecl();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case VAL:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_3;
        }
        exp2 = ValDecl();
      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ArchitectureTypeDecl() throws ParseException {
 /*@bgen(jjtree) ArchitectureTypeDecl */
  ASTArchitectureTypeDecl jjtn000 = new ASTArchitectureTypeDecl(JJTARCHITECTURETYPEDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token name; Node body;
    try {
      jj_consume_token(ARCHITECTURE);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      body = ArchElemDeclSeq();
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ArchElemDeclSeq() throws ParseException {
 /*@bgen(jjtree) ArchElemDeclSeq */
  ASTArchElemDeclSeq jjtn000 = new ASTArchElemDeclSeq(JJTARCHELEMDECLSEQ);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Node exp1; Node exp2;
    try {
      exp1 = ArchElemDecls();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMPONENTS:
        case CONNECTORS:
        case ATTACHMENTS:
        case ENTRYPOINTS:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_4;
        }
        exp2 = ArchElemDecls();

      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ArchElemDecls() throws ParseException {
  Node exp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COMPONENTS:
      exp = ComponentDecls();
                                  {if (true) return null;}
      break;
    case CONNECTORS:
      exp = ConnectorDecls();
                                  {if (true) return null;}
      break;
    case ATTACHMENTS:
      exp = AttachmentDecls();
                                  {if (true) return null;}
      break;
    case ENTRYPOINTS:
      exp = EntryPointDecls();
                                  {if (true) return null;}
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ComponentDecls() throws ParseException {
 /*@bgen(jjtree) ComponentDecls */
  ASTComponentDecls jjtn000 = new ASTComponentDecls(JJTCOMPONENTDECLS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token type; Token name; boolean isExternal = false;
    try {
      jj_consume_token(COMPONENTS);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      type = jj_consume_token(IDENTIFIER);
      name = jj_consume_token(IDENTIFIER);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_5;
        }
        jj_consume_token(COMMA);
        jj_consume_token(IDENTIFIER);
      }
      jj_consume_token(NEWLINE);
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[10] = jj_gen;
          break label_6;
        }
        type = jj_consume_token(IDENTIFIER);
        name = jj_consume_token(IDENTIFIER);
        label_7:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[11] = jj_gen;
            break label_7;
          }
          jj_consume_token(COMMA);
          jj_consume_token(IDENTIFIER);
        }
        jj_consume_token(NEWLINE);
      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ConnectorDecls() throws ParseException {
 /*@bgen(jjtree) ConnectorDecls */
  ASTConnectorDecls jjtn000 = new ASTConnectorDecls(JJTCONNECTORDECLS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token type; Token name; boolean isExternal = false;
    try {
      jj_consume_token(CONNECTORS);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      type = jj_consume_token(IDENTIFIER);
      name = jj_consume_token(IDENTIFIER);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_8;
        }
        jj_consume_token(COMMA);
        jj_consume_token(IDENTIFIER);
      }
      jj_consume_token(NEWLINE);
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[13] = jj_gen;
          break label_9;
        }
        type = jj_consume_token(IDENTIFIER);
        name = jj_consume_token(IDENTIFIER);
        label_10:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[14] = jj_gen;
            break label_10;
          }
          jj_consume_token(COMMA);
          jj_consume_token(IDENTIFIER);
        }
        jj_consume_token(NEWLINE);
      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node AttachmentDecls() throws ParseException {
 /*@bgen(jjtree) AttachmentDecls */
  ASTAttachmentDecls jjtn000 = new ASTAttachmentDecls(JJTATTACHMENTDECLS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);String p1; String p2; Token cntr;
    try {
      jj_consume_token(ATTACHMENTS);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      jj_consume_token(CONNECT);
      p1 = Segment();
      jj_consume_token(AND);
      p2 = Segment();
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[15] = jj_gen;
          break label_11;
        }
        jj_consume_token(AND);
        Segment();
      }
      jj_consume_token(WITH);
      cntr = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_12;
        }
        p1 = Segment();
        jj_consume_token(AND);
        p2 = Segment();
        label_13:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case AND:
            ;
            break;
          default:
            jj_la1[17] = jj_gen;
            break label_13;
          }
          jj_consume_token(AND);
          Segment();
        }
        jj_consume_token(WITH);
        cntr = jj_consume_token(IDENTIFIER);
        jj_consume_token(NEWLINE);
      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node BindingDecls() throws ParseException {
 /*@bgen(jjtree) BindingDecls */
  ASTBindingDecls jjtn000 = new ASTBindingDecls(JJTBINDINGDECLS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t; String b;
    try {
      jj_consume_token(BINDINGS);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      t = jj_consume_token(IDENTIFIER);
      jj_consume_token(IS);
      b = Segment();
      jj_consume_token(NEWLINE);
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[18] = jj_gen;
          break label_14;
        }
        t = jj_consume_token(IDENTIFIER);
        jj_consume_token(IS);
        b = Segment();

        jj_consume_token(NEWLINE);
      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node EntryPointDecls() throws ParseException {
 /*@bgen(jjtree) EntryPointDecls */
  ASTEntryPointDecls jjtn000 = new ASTEntryPointDecls(JJTENTRYPOINTDECLS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t; Token point;
    try {
      jj_consume_token(ENTRYPOINTS);
      jj_consume_token(NEWLINE);
      jj_consume_token(INDENT);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[19] = jj_gen;
          break label_15;
        }
        jj_consume_token(IDENTIFIER);
        jj_consume_token(COLON);
        jj_consume_token(IDENTIFIER);
        jj_consume_token(NEWLINE);
      }
      jj_consume_token(DEDENT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node MemberDecls() throws ParseException {
  Node exp1; Node exp2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAL:
      exp1 = ValDecl();
      break;
    case PORT:
      exp1 = PortDecl();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  final public Node PortDecl() throws ParseException {
 /*@bgen(jjtree) PortDecl */
  ASTPortDecl jjtn000 = new ASTPortDecl(JJTPORTDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token p; Token req = null; Token prov = null;
    try {
      jj_consume_token(PORT);
      p = jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REQUIRES:
        jj_consume_token(REQUIRES);
        req = jj_consume_token(IDENTIFIER);
        break;
      case PROVIDES:
        jj_consume_token(PROVIDES);
        prov = jj_consume_token(IDENTIFIER);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(NEWLINE);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Node ValDecl() throws ParseException {
 /*@bgen(jjtree) ValDecl */
  ASTValDecl jjtn000 = new ASTValDecl(JJTVALDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);Token t; Token name;
    try {
      jj_consume_token(VAL);
      name = jj_consume_token(IDENTIFIER);
      jj_consume_token(COLON);
      t = jj_consume_token(IDENTIFIER);
      jj_consume_token(NEWLINE);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return null;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public String Segment() throws ParseException {
  String s; Token t;
    t = jj_consume_token(IDENTIFIER);
                     s = t.image;
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DOT:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_16;
      }
      jj_consume_token(DOT);
      t = jj_consume_token(IDENTIFIER);
                             s = s + "." + t.image;
    }
      {if (true) return null;}
    throw new Error("Missing return statement in function");
  }

  /** User defined Token Manager. */
  public TokenManager token_source;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[23];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x146,0x147,0x146,0x4,0x101ce,0x101ce,0x80,0x8e00,0x8e00,0x100000,0x8000000,0x100000,0x100000,0x8000000,0x100000,0x2000,0x8000000,0x2000,0x8000000,0x8000000,0x88,0x30,0x80000,};
   }


  /** Constructor with user supplied Token Manager. */
  public ArchParser(TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 23; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}