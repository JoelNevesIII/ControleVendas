PGDMP     	                 
    y            controle_vendas    10.18    10.18     #           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            $           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            %           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �            1259    16693    funcao    TABLE     �   CREATE TABLE public.funcao (
    id_funcao integer NOT NULL,
    funcao character varying NOT NULL,
    funcao_venda boolean,
    area_venda integer
);
    DROP TABLE public.funcao;
       public         postgres    false            �            1259    16699    funcao_id_funcao_seq    SEQUENCE     �   CREATE SEQUENCE public.funcao_id_funcao_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.funcao_id_funcao_seq;
       public       postgres    false    206            &           0    0    funcao_id_funcao_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.funcao_id_funcao_seq OWNED BY public.funcao.id_funcao;
            public       postgres    false    207            �
           2604    16732    funcao id_funcao    DEFAULT     t   ALTER TABLE ONLY public.funcao ALTER COLUMN id_funcao SET DEFAULT nextval('public.funcao_id_funcao_seq'::regclass);
 ?   ALTER TABLE public.funcao ALTER COLUMN id_funcao DROP DEFAULT;
       public       postgres    false    207    206                      0    16693    funcao 
   TABLE DATA               M   COPY public.funcao (id_funcao, funcao, funcao_venda, area_venda) FROM stdin;
    public       postgres    false    206   �
       '           0    0    funcao_id_funcao_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.funcao_id_funcao_seq', 25, true);
            public       postgres    false    207            �
           2606    16748    funcao funcao_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.funcao
    ADD CONSTRAINT funcao_pkey PRIMARY KEY (id_funcao);
 <   ALTER TABLE ONLY public.funcao DROP CONSTRAINT funcao_pkey;
       public         postgres    false    206            �
           2606    16757    funcao area_venda    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcao
    ADD CONSTRAINT area_venda FOREIGN KEY (area_venda) REFERENCES public.area_venda(id_area) NOT VALID;
 ;   ALTER TABLE ONLY public.funcao DROP CONSTRAINT area_venda;
       public       postgres    false    206               F   x�3�LL����L���2D�r�$B�Ɯ%��%�n�9ũP!K�PRi:g	�!��)��W��Q���� ���     