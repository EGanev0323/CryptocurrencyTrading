CREATE TABLE [users] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    balance DECIMAL(18, 2) NOT NULL DEFAULT 10000
    );

CREATE TABLE [transactions] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES [users](id),
    crypto_symbol VARCHAR(10) NOT NULL,
    quantity DECIMAL(18, 8) NOT NULL,
    price DECIMAL(18, 2) NOT NULL,
    type VARCHAR(10) NOT NULL, -- 'BUY' or 'SELL'
    timestamp DATETIME DEFAULT GETDATE()
    );

CREATE TABLE [holdings] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES [users](id),
    crypto_symbol VARCHAR(10) NOT NULL,
    quantity DECIMAL(18, 8) NOT NULL,
    CONSTRAINT uq_user_crypto UNIQUE(user_id, crypto_symbol)
    );
