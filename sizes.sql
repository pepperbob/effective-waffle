-- table on disk
with sizes as (
    SELECT
    pg_table_size('json_integer') as int_size,
    pg_table_size('json_uuid') as uuid_size
)
select
int_size,
uuid_size,
1 - int_size::numeric/uuid_size as more
from
sizes;

-- total on disk
with sizes as (
    SELECT
    pg_total_relation_size('json_integer') as int_size,
    pg_total_relation_size('json_uuid') as uuid_size
)
select
int_size,
uuid_size,
1 - int_size::numeric/uuid_size as more
from
sizes;