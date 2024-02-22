CREATE TABLE [users] (
  [id] integer PRIMARY KEY IDENTITY,
  [username] varchar(255),
  [password] varchar(255),
  [created_at] datetime DEFAULT GETDATE()
);

CREATE TABLE [info] (
  [user_id] integer PRIMARY KEY,
  [DOB] date,
  [Address] varchar(255),
  [Phone_number] varchar(255),
  [created_at] datetime DEFAULT GETDATE(),
  FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
);

CREATE TABLE [flag_lookup] (
  [id] integer PRIMARY KEY,
  [value] varchar(255)
);

CREATE TABLE [type_lookup] (
  [id] integer PRIMARY KEY,
  [value] varchar(255)
);

CREATE TABLE [data] (
  [user_id] integer,
  [flag_id] integer,
  [type_id] integer,
  [created_at] datetime DEFAULT GETDATE(),
  [amount] integer,
  FOREIGN KEY ([user_id]) REFERENCES [users] ([id]),
  FOREIGN KEY ([flag_id]) REFERENCES [flag_lookup] ([id]),
  FOREIGN KEY ([type_id]) REFERENCES [type_lookup] ([id])
);
