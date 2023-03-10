PGDMP             
        
    z            bd_parqueamiento    14.3    14.3 7    5           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            6           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            7           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            8           1262    41496    bd_parqueamiento    DATABASE     k   CREATE DATABASE bd_parqueamiento WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Peru.1252';
     DROP DATABASE bd_parqueamiento;
                postgres    false            ?            1259    41648    detalle_permiso    TABLE     f   CREATE TABLE public.detalle_permiso (
    permiso_id integer NOT NULL,
    rol_id integer NOT NULL
);
 #   DROP TABLE public.detalle_permiso;
       public         heap    postgres    false            ?            1259    41747    ingreso    TABLE     )  CREATE TABLE public.ingreso (
    codigo character varying(20) NOT NULL,
    placa character varying(8),
    fecha_ingreso timestamp without time zone DEFAULT now(),
    fecha_salida timestamp without time zone,
    monto numeric(8,2) DEFAULT 0.0,
    tarifa_id integer,
    usuario_id integer
);
    DROP TABLE public.ingreso;
       public         heap    postgres    false            ?            1259    41639    permiso    TABLE     h   CREATE TABLE public.permiso (
    permiso_id integer NOT NULL,
    descripcion character varying(50)
);
    DROP TABLE public.permiso;
       public         heap    postgres    false            ?            1259    41638    permiso_permiso_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.permiso_permiso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.permiso_permiso_id_seq;
       public          postgres    false    212            9           0    0    permiso_permiso_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.permiso_permiso_id_seq OWNED BY public.permiso.permiso_id;
          public          postgres    false    211            ?            1259    41616    rol    TABLE     `   CREATE TABLE public.rol (
    rol_id integer NOT NULL,
    descripcion character varying(30)
);
    DROP TABLE public.rol;
       public         heap    postgres    false            ?            1259    41615    rol_rol_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.rol_rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.rol_rol_id_seq;
       public          postgres    false    210            :           0    0    rol_rol_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.rol_rol_id_seq OWNED BY public.rol.rol_id;
          public          postgres    false    209            ?            1259    41673    tarifa    TABLE     ?   CREATE TABLE public.tarifa (
    tarifa_id integer NOT NULL,
    monto_hora numeric(6,2),
    monto_dia numeric(6,2),
    tipo_vehiculo_id integer
);
    DROP TABLE public.tarifa;
       public         heap    postgres    false            ?            1259    41672    tarifa_tarifa_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.tarifa_tarifa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.tarifa_tarifa_id_seq;
       public          postgres    false    217            ;           0    0    tarifa_tarifa_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.tarifa_tarifa_id_seq OWNED BY public.tarifa.tarifa_id;
          public          postgres    false    216            ?            1259    41664    tipo_vehiculo    TABLE     t   CREATE TABLE public.tipo_vehiculo (
    tipo_vehiculo_id integer NOT NULL,
    descripcion character varying(50)
);
 !   DROP TABLE public.tipo_vehiculo;
       public         heap    postgres    false            ?            1259    41663 "   tipo_vehiculo_tipo_vehiculo_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.tipo_vehiculo_tipo_vehiculo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.tipo_vehiculo_tipo_vehiculo_id_seq;
       public          postgres    false    215            <           0    0 "   tipo_vehiculo_tipo_vehiculo_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.tipo_vehiculo_tipo_vehiculo_id_seq OWNED BY public.tipo_vehiculo.tipo_vehiculo_id;
          public          postgres    false    214            ?            1259    41715    usuario    TABLE     d  CREATE TABLE public.usuario (
    usuario_id integer NOT NULL,
    documento character varying(15),
    nombres character varying(30),
    apellidos character varying(30),
    fecha_nacimiento date,
    correo character varying(80),
    telefono character varying(9),
    clave character varying(50),
    estado boolean DEFAULT true,
    rol_id integer
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            ?            1259    41714    usuario_usuario_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.usuario_usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_usuario_id_seq;
       public          postgres    false    219            =           0    0    usuario_usuario_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_usuario_id_seq OWNED BY public.usuario.usuario_id;
          public          postgres    false    218            y           2604    41642    permiso permiso_id    DEFAULT     x   ALTER TABLE ONLY public.permiso ALTER COLUMN permiso_id SET DEFAULT nextval('public.permiso_permiso_id_seq'::regclass);
 A   ALTER TABLE public.permiso ALTER COLUMN permiso_id DROP DEFAULT;
       public          postgres    false    212    211    212            x           2604    41619 
   rol rol_id    DEFAULT     h   ALTER TABLE ONLY public.rol ALTER COLUMN rol_id SET DEFAULT nextval('public.rol_rol_id_seq'::regclass);
 9   ALTER TABLE public.rol ALTER COLUMN rol_id DROP DEFAULT;
       public          postgres    false    209    210    210            {           2604    41676    tarifa tarifa_id    DEFAULT     t   ALTER TABLE ONLY public.tarifa ALTER COLUMN tarifa_id SET DEFAULT nextval('public.tarifa_tarifa_id_seq'::regclass);
 ?   ALTER TABLE public.tarifa ALTER COLUMN tarifa_id DROP DEFAULT;
       public          postgres    false    216    217    217            z           2604    41667    tipo_vehiculo tipo_vehiculo_id    DEFAULT     ?   ALTER TABLE ONLY public.tipo_vehiculo ALTER COLUMN tipo_vehiculo_id SET DEFAULT nextval('public.tipo_vehiculo_tipo_vehiculo_id_seq'::regclass);
 M   ALTER TABLE public.tipo_vehiculo ALTER COLUMN tipo_vehiculo_id DROP DEFAULT;
       public          postgres    false    215    214    215            |           2604    41718    usuario usuario_id    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN usuario_id SET DEFAULT nextval('public.usuario_usuario_id_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN usuario_id DROP DEFAULT;
       public          postgres    false    219    218    219            +          0    41648    detalle_permiso 
   TABLE DATA           =   COPY public.detalle_permiso (permiso_id, rol_id) FROM stdin;
    public          postgres    false    213   ?@       2          0    41747    ingreso 
   TABLE DATA           k   COPY public.ingreso (codigo, placa, fecha_ingreso, fecha_salida, monto, tarifa_id, usuario_id) FROM stdin;
    public          postgres    false    220   ?@       *          0    41639    permiso 
   TABLE DATA           :   COPY public.permiso (permiso_id, descripcion) FROM stdin;
    public          postgres    false    212   rA       (          0    41616    rol 
   TABLE DATA           2   COPY public.rol (rol_id, descripcion) FROM stdin;
    public          postgres    false    210   ?A       /          0    41673    tarifa 
   TABLE DATA           T   COPY public.tarifa (tarifa_id, monto_hora, monto_dia, tipo_vehiculo_id) FROM stdin;
    public          postgres    false    217   B       -          0    41664    tipo_vehiculo 
   TABLE DATA           F   COPY public.tipo_vehiculo (tipo_vehiculo_id, descripcion) FROM stdin;
    public          postgres    false    215   AB       1          0    41715    usuario 
   TABLE DATA           ?   COPY public.usuario (usuario_id, documento, nombres, apellidos, fecha_nacimiento, correo, telefono, clave, estado, rol_id) FROM stdin;
    public          postgres    false    219   ?B       >           0    0    permiso_permiso_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.permiso_permiso_id_seq', 7, true);
          public          postgres    false    211            ?           0    0    rol_rol_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.rol_rol_id_seq', 1, true);
          public          postgres    false    209            @           0    0    tarifa_tarifa_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tarifa_tarifa_id_seq', 2, true);
          public          postgres    false    216            A           0    0 "   tipo_vehiculo_tipo_vehiculo_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.tipo_vehiculo_tipo_vehiculo_id_seq', 12, true);
          public          postgres    false    214            B           0    0    usuario_usuario_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_usuario_id_seq', 3, true);
          public          postgres    false    218            ?           2606    41652 $   detalle_permiso detalle_permiso_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.detalle_permiso
    ADD CONSTRAINT detalle_permiso_pkey PRIMARY KEY (permiso_id, rol_id);
 N   ALTER TABLE ONLY public.detalle_permiso DROP CONSTRAINT detalle_permiso_pkey;
       public            postgres    false    213    213            ?           2606    41753    ingreso ingreso_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.ingreso
    ADD CONSTRAINT ingreso_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.ingreso DROP CONSTRAINT ingreso_pkey;
       public            postgres    false    220            ?           2606    41646    permiso permiso_descripcion_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_descripcion_key UNIQUE (descripcion);
 I   ALTER TABLE ONLY public.permiso DROP CONSTRAINT permiso_descripcion_key;
       public            postgres    false    212            ?           2606    41644    permiso permiso_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_pkey PRIMARY KEY (permiso_id);
 >   ALTER TABLE ONLY public.permiso DROP CONSTRAINT permiso_pkey;
       public            postgres    false    212            ?           2606    41623    rol rol_descripcion_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_descripcion_key UNIQUE (descripcion);
 A   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_descripcion_key;
       public            postgres    false    210            ?           2606    41621    rol rol_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (rol_id);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public            postgres    false    210            ?           2606    41678    tarifa tarifa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.tarifa
    ADD CONSTRAINT tarifa_pkey PRIMARY KEY (tarifa_id);
 <   ALTER TABLE ONLY public.tarifa DROP CONSTRAINT tarifa_pkey;
       public            postgres    false    217            ?           2606    41671 +   tipo_vehiculo tipo_vehiculo_descripcion_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.tipo_vehiculo
    ADD CONSTRAINT tipo_vehiculo_descripcion_key UNIQUE (descripcion);
 U   ALTER TABLE ONLY public.tipo_vehiculo DROP CONSTRAINT tipo_vehiculo_descripcion_key;
       public            postgres    false    215            ?           2606    41669     tipo_vehiculo tipo_vehiculo_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.tipo_vehiculo
    ADD CONSTRAINT tipo_vehiculo_pkey PRIMARY KEY (tipo_vehiculo_id);
 J   ALTER TABLE ONLY public.tipo_vehiculo DROP CONSTRAINT tipo_vehiculo_pkey;
       public            postgres    false    215            ?           2606    41723    usuario usuario_documento_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_documento_key UNIQUE (documento);
 G   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_documento_key;
       public            postgres    false    219            ?           2606    41721    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    219            ?           2606    41653 /   detalle_permiso detalle_permiso_permiso_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.detalle_permiso
    ADD CONSTRAINT detalle_permiso_permiso_id_fkey FOREIGN KEY (permiso_id) REFERENCES public.permiso(permiso_id);
 Y   ALTER TABLE ONLY public.detalle_permiso DROP CONSTRAINT detalle_permiso_permiso_id_fkey;
       public          postgres    false    3207    212    213            ?           2606    41658 +   detalle_permiso detalle_permiso_rol_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.detalle_permiso
    ADD CONSTRAINT detalle_permiso_rol_id_fkey FOREIGN KEY (rol_id) REFERENCES public.rol(rol_id);
 U   ALTER TABLE ONLY public.detalle_permiso DROP CONSTRAINT detalle_permiso_rol_id_fkey;
       public          postgres    false    3203    213    210            ?           2606    41754    ingreso ingreso_tarifa_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ingreso
    ADD CONSTRAINT ingreso_tarifa_id_fkey FOREIGN KEY (tarifa_id) REFERENCES public.tarifa(tarifa_id);
 H   ALTER TABLE ONLY public.ingreso DROP CONSTRAINT ingreso_tarifa_id_fkey;
       public          postgres    false    3215    220    217            ?           2606    41759    ingreso ingreso_usuario_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ingreso
    ADD CONSTRAINT ingreso_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id);
 I   ALTER TABLE ONLY public.ingreso DROP CONSTRAINT ingreso_usuario_id_fkey;
       public          postgres    false    3219    220    219            ?           2606    41679 #   tarifa tarifa_tipo_vehiculo_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.tarifa
    ADD CONSTRAINT tarifa_tipo_vehiculo_id_fkey FOREIGN KEY (tipo_vehiculo_id) REFERENCES public.tipo_vehiculo(tipo_vehiculo_id);
 M   ALTER TABLE ONLY public.tarifa DROP CONSTRAINT tarifa_tipo_vehiculo_id_fkey;
       public          postgres    false    215    3213    217            ?           2606    41724    usuario usuario_rol_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_rol_id_fkey FOREIGN KEY (rol_id) REFERENCES public.rol(rol_id);
 E   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_rol_id_fkey;
       public          postgres    false    219    3203    210            +   (   x?3?4?2bc 6bS 6bs??P?(f????? {?\      2   ?   x?e?;
1@??en ?}???~?)?C?Q??q?;p??vά????Y?_???{?W}ƚ?#QDۡ7?F??0?/?&y+??rN?@@a䃯:?*???&??
?jq̧?ZcJb???Kj???A>4o?#?ޫ?%?      *   X   x?Ȼ
?0F???a??89???K?Q"6????d;ߩ
??B?Y?k?m?处?0?9???q??z???[?????at^G	?5J      (   %   x?3?tt????	rt??2?2????=... ?>?      /   "   x?3?4?30?4?\F??`??4?????? YC?      -   A   x?3????W???su??2?tv????sq?2?t??2?(q???24?	r??q?????? ???      1   ?   x?U?Mj?0???????g???.?c[Jd??R?%zJ????>??s?yh???XalR&?mx??TSb?yC??xu?E?z??"y??u?"??6??o@e!??¼?UO??v??????U?&?o???@? ??u?cば#1?YRt8?!?p?e?2K???i[.?ck:k?a????l?s??pr_??c?:;     