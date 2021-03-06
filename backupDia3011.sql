PGDMP         6            
    y            controle_vendas    10.18    10.18 Y    d           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            e           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            f           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            g           1262    16507    controle_vendas    DATABASE     ?   CREATE DATABASE controle_vendas WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE controle_vendas;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            h           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            i           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    16508 
   area_venda    TABLE     f   CREATE TABLE public.area_venda (
    id_area integer NOT NULL,
    nome character varying NOT NULL
);
    DROP TABLE public.area_venda;
       public         postgres    false    3            ?            1259    16514    area_venda_id_area_seq    SEQUENCE     ?   CREATE SEQUENCE public.area_venda_id_area_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.area_venda_id_area_seq;
       public       postgres    false    3    196            j           0    0    area_venda_id_area_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.area_venda_id_area_seq OWNED BY public.area_venda.id_area;
            public       postgres    false    197            ?            1259    16516    bairro    TABLE     ?   CREATE TABLE public.bairro (
    id_bairro integer NOT NULL,
    nome character varying NOT NULL,
    id_cidade integer NOT NULL
);
    DROP TABLE public.bairro;
       public         postgres    false    3            ?            1259    16522    bairro_id_bairro_seq    SEQUENCE     ?   CREATE SEQUENCE public.bairro_id_bairro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.bairro_id_bairro_seq;
       public       postgres    false    3    198            k           0    0    bairro_id_bairro_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.bairro_id_bairro_seq OWNED BY public.bairro.id_bairro;
            public       postgres    false    199            ?            1259    16524    cidade    TABLE     ?   CREATE TABLE public.cidade (
    id_cidade integer NOT NULL,
    nome character varying NOT NULL,
    id_estado integer NOT NULL
);
    DROP TABLE public.cidade;
       public         postgres    false    3            ?            1259    16530    cidade_id_cidade_seq    SEQUENCE     ?   CREATE SEQUENCE public.cidade_id_cidade_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cidade_id_cidade_seq;
       public       postgres    false    3    200            l           0    0    cidade_id_cidade_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cidade_id_cidade_seq OWNED BY public.cidade.id_cidade;
            public       postgres    false    201            ?            1259    16532    cliente    TABLE     ?  CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    nome character varying NOT NULL,
    id_bairro integer NOT NULL,
    id_cidade integer NOT NULL,
    id_estado integer NOT NULL,
    cpf_cnpj character varying NOT NULL,
    cpf character varying,
    cnpj character varying,
    qt_compras integer NOT NULL,
    rua character varying NOT NULL,
    numero integer NOT NULL
);
    DROP TABLE public.cliente;
       public         postgres    false    3            ?            1259    16538    cliente_id_cliente_seq    SEQUENCE     ?   CREATE SEQUENCE public.cliente_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cliente_id_cliente_seq;
       public       postgres    false    3    202            m           0    0    cliente_id_cliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;
            public       postgres    false    203            ?            1259    16540    estado    TABLE     ?   CREATE TABLE public.estado (
    id_estado integer NOT NULL,
    uf character varying NOT NULL,
    nome_estado character varying NOT NULL
);
    DROP TABLE public.estado;
       public         postgres    false    3            ?            1259    16546    estado_id_estado_seq    SEQUENCE     ?   CREATE SEQUENCE public.estado_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.estado_id_estado_seq;
       public       postgres    false    204    3            n           0    0    estado_id_estado_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.estado_id_estado_seq OWNED BY public.estado.id_estado;
            public       postgres    false    205            ?            1259    16548    funcao    TABLE     ?   CREATE TABLE public.funcao (
    id_funcao integer NOT NULL,
    funcao character varying NOT NULL,
    funcao_venda boolean,
    area_venda integer
);
    DROP TABLE public.funcao;
       public         postgres    false    3            ?            1259    16554    funcao_id_funcao_seq    SEQUENCE     ?   CREATE SEQUENCE public.funcao_id_funcao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.funcao_id_funcao_seq;
       public       postgres    false    3    206            o           0    0    funcao_id_funcao_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.funcao_id_funcao_seq OWNED BY public.funcao.id_funcao;
            public       postgres    false    207            ?            1259    16556    nota    TABLE     l   CREATE TABLE public.nota (
    id_nota integer NOT NULL,
    id_cliente integer,
    valor_total integer
);
    DROP TABLE public.nota;
       public         postgres    false    3            ?            1259    16559    nota_id_nota_seq    SEQUENCE     ?   CREATE SEQUENCE public.nota_id_nota_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.nota_id_nota_seq;
       public       postgres    false    3    208            p           0    0    nota_id_nota_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.nota_id_nota_seq OWNED BY public.nota.id_nota;
            public       postgres    false    209            ?            1259    16561    produto    TABLE     ?  CREATE TABLE public.produto (
    id_produto integer NOT NULL,
    id_area integer NOT NULL,
    nome character varying NOT NULL,
    descricao character varying NOT NULL,
    quantidade double precision NOT NULL,
    est_max double precision,
    est_min double precision,
    controla_est boolean NOT NULL,
    comissao double precision NOT NULL,
    valor_venda double precision NOT NULL,
    valor_custo double precision NOT NULL
);
    DROP TABLE public.produto;
       public         postgres    false    3            ?            1259    16567    produto_id_produto_seq    SEQUENCE     ?   CREATE SEQUENCE public.produto_id_produto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.produto_id_produto_seq;
       public       postgres    false    3    210            q           0    0    produto_id_produto_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.produto_id_produto_seq OWNED BY public.produto.id_produto;
            public       postgres    false    211            ?            1259    16569    produto_nota    TABLE     ?   CREATE TABLE public.produto_nota (
    id_produto_nota integer NOT NULL,
    id_produto integer NOT NULL,
    id_nota integer NOT NULL,
    quantidade integer NOT NULL,
    valor_vendido integer NOT NULL,
    id_vendedor integer
);
     DROP TABLE public.produto_nota;
       public         postgres    false    3            ?            1259    16572     produto_nota_id_produto_nota_seq    SEQUENCE     ?   CREATE SEQUENCE public.produto_nota_id_produto_nota_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.produto_nota_id_produto_nota_seq;
       public       postgres    false    212    3            r           0    0     produto_nota_id_produto_nota_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.produto_nota_id_produto_nota_seq OWNED BY public.produto_nota.id_produto_nota;
            public       postgres    false    213            ?            1259    16574    usuario    TABLE     ?   CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nome character varying NOT NULL,
    senha character varying NOT NULL,
    id_funcao integer NOT NULL
);
    DROP TABLE public.usuario;
       public         postgres    false    3            ?            1259    16580    usuario_id_usuario_seq    SEQUENCE     ?   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public       postgres    false    3    214            s           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
            public       postgres    false    215            ?
           2604    16582    area_venda id_area    DEFAULT     x   ALTER TABLE ONLY public.area_venda ALTER COLUMN id_area SET DEFAULT nextval('public.area_venda_id_area_seq'::regclass);
 A   ALTER TABLE public.area_venda ALTER COLUMN id_area DROP DEFAULT;
       public       postgres    false    197    196            ?
           2604    16583    bairro id_bairro    DEFAULT     t   ALTER TABLE ONLY public.bairro ALTER COLUMN id_bairro SET DEFAULT nextval('public.bairro_id_bairro_seq'::regclass);
 ?   ALTER TABLE public.bairro ALTER COLUMN id_bairro DROP DEFAULT;
       public       postgres    false    199    198            ?
           2604    16584    cidade id_cidade    DEFAULT     t   ALTER TABLE ONLY public.cidade ALTER COLUMN id_cidade SET DEFAULT nextval('public.cidade_id_cidade_seq'::regclass);
 ?   ALTER TABLE public.cidade ALTER COLUMN id_cidade DROP DEFAULT;
       public       postgres    false    201    200            ?
           2604    16585    cliente id_cliente    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN id_cliente DROP DEFAULT;
       public       postgres    false    203    202            ?
           2604    16586    estado id_estado    DEFAULT     t   ALTER TABLE ONLY public.estado ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_id_estado_seq'::regclass);
 ?   ALTER TABLE public.estado ALTER COLUMN id_estado DROP DEFAULT;
       public       postgres    false    205    204            ?
           2604    24706    funcao id_funcao    DEFAULT     t   ALTER TABLE ONLY public.funcao ALTER COLUMN id_funcao SET DEFAULT nextval('public.funcao_id_funcao_seq'::regclass);
 ?   ALTER TABLE public.funcao ALTER COLUMN id_funcao DROP DEFAULT;
       public       postgres    false    207    206            ?
           2604    16588    nota id_nota    DEFAULT     l   ALTER TABLE ONLY public.nota ALTER COLUMN id_nota SET DEFAULT nextval('public.nota_id_nota_seq'::regclass);
 ;   ALTER TABLE public.nota ALTER COLUMN id_nota DROP DEFAULT;
       public       postgres    false    209    208            ?
           2604    16589    produto id_produto    DEFAULT     x   ALTER TABLE ONLY public.produto ALTER COLUMN id_produto SET DEFAULT nextval('public.produto_id_produto_seq'::regclass);
 A   ALTER TABLE public.produto ALTER COLUMN id_produto DROP DEFAULT;
       public       postgres    false    211    210            ?
           2604    16590    produto_nota id_produto_nota    DEFAULT     ?   ALTER TABLE ONLY public.produto_nota ALTER COLUMN id_produto_nota SET DEFAULT nextval('public.produto_nota_id_produto_nota_seq'::regclass);
 K   ALTER TABLE public.produto_nota ALTER COLUMN id_produto_nota DROP DEFAULT;
       public       postgres    false    213    212            ?
           2604    16591    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public       postgres    false    215    214            N          0    16508 
   area_venda 
   TABLE DATA               3   COPY public.area_venda (id_area, nome) FROM stdin;
    public       postgres    false    196   ?c       P          0    16516    bairro 
   TABLE DATA               <   COPY public.bairro (id_bairro, nome, id_cidade) FROM stdin;
    public       postgres    false    198   Kd       R          0    16524    cidade 
   TABLE DATA               <   COPY public.cidade (id_cidade, nome, id_estado) FROM stdin;
    public       postgres    false    200   ?d       T          0    16532    cliente 
   TABLE DATA               ?   COPY public.cliente (id_cliente, nome, id_bairro, id_cidade, id_estado, cpf_cnpj, cpf, cnpj, qt_compras, rua, numero) FROM stdin;
    public       postgres    false    202   ?d       V          0    16540    estado 
   TABLE DATA               <   COPY public.estado (id_estado, uf, nome_estado) FROM stdin;
    public       postgres    false    204   Ze       X          0    16548    funcao 
   TABLE DATA               M   COPY public.funcao (id_funcao, funcao, funcao_venda, area_venda) FROM stdin;
    public       postgres    false    206   ?e       Z          0    16556    nota 
   TABLE DATA               @   COPY public.nota (id_nota, id_cliente, valor_total) FROM stdin;
    public       postgres    false    208   1f       \          0    16561    produto 
   TABLE DATA               ?   COPY public.produto (id_produto, id_area, nome, descricao, quantidade, est_max, est_min, controla_est, comissao, valor_venda, valor_custo) FROM stdin;
    public       postgres    false    210   af       ^          0    16569    produto_nota 
   TABLE DATA               t   COPY public.produto_nota (id_produto_nota, id_produto, id_nota, quantidade, valor_vendido, id_vendedor) FROM stdin;
    public       postgres    false    212   Hg       `          0    16574    usuario 
   TABLE DATA               E   COPY public.usuario (id_usuario, nome, senha, id_funcao) FROM stdin;
    public       postgres    false    214   ?g       t           0    0    area_venda_id_area_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.area_venda_id_area_seq', 14, true);
            public       postgres    false    197            u           0    0    bairro_id_bairro_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.bairro_id_bairro_seq', 3, true);
            public       postgres    false    199            v           0    0    cidade_id_cidade_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cidade_id_cidade_seq', 3, true);
            public       postgres    false    201            w           0    0    cliente_id_cliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 6, true);
            public       postgres    false    203            x           0    0    estado_id_estado_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.estado_id_estado_seq', 2, true);
            public       postgres    false    205            y           0    0    funcao_id_funcao_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.funcao_id_funcao_seq', 27, true);
            public       postgres    false    207            z           0    0    nota_id_nota_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.nota_id_nota_seq', 119, true);
            public       postgres    false    209            {           0    0    produto_id_produto_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.produto_id_produto_seq', 27, true);
            public       postgres    false    211            |           0    0     produto_nota_id_produto_nota_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.produto_nota_id_produto_nota_seq', 163, true);
            public       postgres    false    213            }           0    0    usuario_id_usuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 11, true);
            public       postgres    false    215            ?
           2606    16593    area_venda area_venda_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.area_venda
    ADD CONSTRAINT area_venda_pkey PRIMARY KEY (id_area);
 D   ALTER TABLE ONLY public.area_venda DROP CONSTRAINT area_venda_pkey;
       public         postgres    false    196            ?
           2606    16595    bairro bairro_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT bairro_pkey PRIMARY KEY (id_bairro);
 <   ALTER TABLE ONLY public.bairro DROP CONSTRAINT bairro_pkey;
       public         postgres    false    198            ?
           2606    16597    cidade cidade_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id_cidade);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public         postgres    false    200            ?
           2606    16599    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public         postgres    false    202            ?
           2606    16601    estado estado_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id_estado);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public         postgres    false    204            ?
           2606    16603    funcao funcao_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.funcao
    ADD CONSTRAINT funcao_pkey PRIMARY KEY (id_funcao);
 <   ALTER TABLE ONLY public.funcao DROP CONSTRAINT funcao_pkey;
       public         postgres    false    206            ?
           2606    16605    nota nota_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_pkey PRIMARY KEY (id_nota);
 8   ALTER TABLE ONLY public.nota DROP CONSTRAINT nota_pkey;
       public         postgres    false    208            ?
           2606    16607    produto_nota produto_nota_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.produto_nota
    ADD CONSTRAINT produto_nota_pkey PRIMARY KEY (id_produto_nota);
 H   ALTER TABLE ONLY public.produto_nota DROP CONSTRAINT produto_nota_pkey;
       public         postgres    false    212            ?
           2606    16609    produto produto_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    210            ?
           2606    16611    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    214            ?
           2606    16612    funcao area_venda    FK CONSTRAINT     ?   ALTER TABLE ONLY public.funcao
    ADD CONSTRAINT area_venda FOREIGN KEY (area_venda) REFERENCES public.area_venda(id_area) NOT VALID;
 ;   ALTER TABLE ONLY public.funcao DROP CONSTRAINT area_venda;
       public       postgres    false    196    206    2743            ?
           2606    16617    produto id_area    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT id_area FOREIGN KEY (id_area) REFERENCES public.area_venda(id_area) NOT VALID;
 9   ALTER TABLE ONLY public.produto DROP CONSTRAINT id_area;
       public       postgres    false    210    196    2743            ?
           2606    16622    cliente id_bairro    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT id_bairro FOREIGN KEY (id_bairro) REFERENCES public.bairro(id_bairro) NOT VALID;
 ;   ALTER TABLE ONLY public.cliente DROP CONSTRAINT id_bairro;
       public       postgres    false    198    2745    202            ?
           2606    16627    cliente id_cidade    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT id_cidade FOREIGN KEY (id_cidade) REFERENCES public.cidade(id_cidade) NOT VALID;
 ;   ALTER TABLE ONLY public.cliente DROP CONSTRAINT id_cidade;
       public       postgres    false    200    202    2747            ?
           2606    16632    bairro id_cidade    FK CONSTRAINT     ?   ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT id_cidade FOREIGN KEY (id_cidade) REFERENCES public.cidade(id_cidade) NOT VALID;
 :   ALTER TABLE ONLY public.bairro DROP CONSTRAINT id_cidade;
       public       postgres    false    200    198    2747            ?
           2606    16637    nota id_cliente    FK CONSTRAINT     ?   ALTER TABLE ONLY public.nota
    ADD CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente) NOT VALID;
 9   ALTER TABLE ONLY public.nota DROP CONSTRAINT id_cliente;
       public       postgres    false    2749    202    208            ?
           2606    16642    cliente id_estado    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) NOT VALID;
 ;   ALTER TABLE ONLY public.cliente DROP CONSTRAINT id_estado;
       public       postgres    false    2751    202    204            ?
           2606    16647    cidade id_estado    FK CONSTRAINT     ?   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT id_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) NOT VALID;
 :   ALTER TABLE ONLY public.cidade DROP CONSTRAINT id_estado;
       public       postgres    false    2751    200    204            ?
           2606    16652    usuario id_funcao    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id_funcao FOREIGN KEY (id_funcao) REFERENCES public.funcao(id_funcao) NOT VALID;
 ;   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id_funcao;
       public       postgres    false    206    2753    214            ?
           2606    16657    produto_nota id_nota    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto_nota
    ADD CONSTRAINT id_nota FOREIGN KEY (id_nota) REFERENCES public.nota(id_nota) NOT VALID;
 >   ALTER TABLE ONLY public.produto_nota DROP CONSTRAINT id_nota;
       public       postgres    false    2755    212    208            ?
           2606    16662    produto_nota id_produto    FK CONSTRAINT     ?   ALTER TABLE ONLY public.produto_nota
    ADD CONSTRAINT id_produto FOREIGN KEY (id_produto) REFERENCES public.produto(id_produto) NOT VALID;
 A   ALTER TABLE ONLY public.produto_nota DROP CONSTRAINT id_produto;
       public       postgres    false    2757    210    212            N   d   x?Eɻ
?0D?z?c?M|?Vv?6BV??~?U???ivۺ?P?݉'?ς?\QP????¢Q???|?????????ă???????Uv??Ӕ??m)g      P   *   x?3???/*N??4?2?I-.I52?9K@LgNc?=... ?	4      R   6   x?3?K?;?(/93_?1?(??Ӑˈ?7??89?4?I-.Iu?4?????? g?&      T      x?}ͽ?P???a?? ap ??Mk? D!????@???????1ͣ??-Q샾F?nXn?tw??Ⱥ??Ê֗5??n*?????֔????ʈG?ϸ??9???c9:"??We^??j??H????G4      V   0   x?3???WH/J?KIUH?W.??
?2?q?,I-.Iu?????? ??
?      X   ?   x?U??
?0Dϳ#?M?z<z??K??Xh???e??[????a~?<1݉w?(s?o?K???J쑷L|4??5?k9??5?򂼭1??I<??nT????I?,??I??X+?s2??.?????}!?=u      Z       x?344?4?41?24??4?411?????? .|      \   ?   x???=?0????x$-??????h]????M?8=<B??4iӖ?bxŐ??:.&r???2?hʋI\??(,SYJ??ei??"伔^(?9V'??%Oa?PJ?%HG?9i?S??I???.q?J?q?#?1/v?ߌԻC-$눍????yt?ϥ?j??P*????2"
Z???ؖ?W????Gz??fN?e??ެҹ????x80???v?      ^   .   x?343?4?444?4?42????243?4?Xr???!W? ??R      `   V   x?3?LL????442?4?2?,I-.I?L?,8}?SRs?r??<c.C????N#??	P?)gV>T?P?!gH?3P(`????? ?tb     